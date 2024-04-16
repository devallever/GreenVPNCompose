package com.allever.compose.green.vpn

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.allever.compose.green.vpn.databinding.ActivityLoadingBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingActivity: Activity() {

    private lateinit var mBinding: ActivityLoadingBinding


    private val DURATION = 20 * 1000L

    private var firstPercent = 0.7
    private var firstDuration = 0.2 * DURATION
    private var firstStep = (firstDuration / (firstPercent * 100)).toInt().toLong()

    private var secondPercent = 0.2
    private var secondDuration = 0.3 * DURATION
    private var secondStep = (secondDuration / (secondPercent * 100)).toInt().toLong()

    private var finalPercent = 0.1
    private var finalDuration = 0.5 * DURATION
    private var finalStep = (finalDuration / (finalPercent * 100)).toInt().toLong()

    private var isLoading = false
    private var job: Job? = null

    private var finishFlag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.apply {
            root.setOnClickListener {
                finishFlag = true
            }
            var step = firstStep
            finishFlag = false
            job = GlobalScope.launch (Dispatchers.Default){
                isLoading = true
                var progress = 0
                var usedTime = 0F
                while (job?.isActive == true && progress < 100) {
                    delay(step)
                    step = if (finishFlag) {
                        10
                    }else if (progress > 100 - finalPercent * 100) {
                        finalStep
                    } else if (progress > firstPercent * 100) {
                        secondStep
                    } else {
                        firstStep
                    }
                    usedTime += step
                    progress += 1
                    log("usedTime = ${usedTime / 1000f}")

                    launch(Dispatchers.Main) {
                        progressBar.progress = progress
                        tvLoading.text = "${progress}%"
                    }
                    if (progress >= 100) {
                        val intent = Intent(this@LoadingActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
                isLoading = false
            }
        }
    }

    private fun log(msg: String) {
        Log.d("LoadingTest", msg)
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }
}