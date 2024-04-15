package com.allever.compose.green.vpn

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.allever.compose.green.vpn.databinding.ActivityLoadingBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingActivity: Activity() {

    private lateinit var mBinding: ActivityLoadingBinding


    private val DURATION = 5 * 1000L

    private var firstPercent = 0.7f
    private var firstDuration = 0.2 * DURATION
    private var firstStep = (firstDuration / (firstPercent * 100)).toInt().toLong()
    private var firstStart = 0

    private var secondPercent = 0.2f
    private var secondDuration = 0.3 * DURATION
    private var secondStep = (secondDuration / (secondPercent * 100)).toInt().toLong()
    private var secondStart = firstDuration

    private var finalPercent = 0.1f
    private var finalDuration = 0.5 * DURATION
    private var finalStep = (finalDuration / (finalPercent * 100)).toInt().toLong()
    private var finalStart = firstDuration + secondDuration

    private var isLoading = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.apply {
            var step = firstStep
            GlobalScope.launch {
                isLoading = true
                var progress = 0
                while (progress < 100) {
                    delay(step)
                    step = if (progress > 100 - finalPercent * 100) {
                        finalStep
                    } else if (progress > firstPercent * 100) {
                        secondStep
                    } else {
                        firstStep
                    }
                    progress += 1
                    progressBar.progress = progress
                    tvLoading.text = "${progress}%"
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
}