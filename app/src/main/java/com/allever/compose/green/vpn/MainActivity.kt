package com.allever.compose.green.vpn

import android.app.StatusBarManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.allever.compose.green.vpn.ui.theme.GreenVPNComposeTheme
import com.allever.compose.green.vpn.ui.theme.PageBgColor
import com.allever.compose.green.vpn.ui.theme.ThemeColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreenVPNComposeTheme {
                //主要设置背景色，暂不知其他方式
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(PageBgColor)
                ) {
                    //页面结构 顶部导航 + 上 + 下
                    Column {
                        //顶部导航
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            //左边图标
                            Icon(
                                painter = painterResource(id = R.drawable.ic_main),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(48.dp)
                                    .padding(12.dp)
                                    .clickable {
                                    },
                                tint = Color.Unspecified
                            )
                            //标题
                            Box(
                                modifier = Modifier
                                    .weight(1F)
                                    .height(56.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = getString(R.string.app_name),
                                    fontSize = 18.sp,
                                    color = Color.White
                                )
                            }
                            //右边图标
                            Icon(
                                painter = painterResource(id = R.drawable.ic_settings),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(48.dp)
                                    .padding(12.dp)
                                    .clickable {
                                    },
                                tint = Color.White
                            )
                        }
                        //上部分
                        Box(
                            modifier = Modifier
                                .weight(1F)
                                .fillMaxWidth()
                        ) {

                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Column(
                                    modifier = Modifier
                                        .weight(1F)
                                        .fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "NOT CONNECT",
                                        color = ThemeColor,
                                        modifier = Modifier,
                                        fontWeight = FontWeight.ExtraBold,
                                        textAlign = TextAlign.Center
                                    )
                                }

                                Box(
                                    modifier = Modifier.size(180.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_ring),
                                        contentDescription = "",
                                        modifier = Modifier.fillMaxSize(),
                                        colorFilter = ColorFilter.tint(ThemeColor)
                                    )

                                    Image(
                                        painter = painterResource(id = R.drawable.ic_thunder),
                                        contentDescription = "",
                                        modifier = Modifier.size(90.dp),
                                        colorFilter = ColorFilter.tint(ThemeColor)
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .weight(1F)
                                        .fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "You are Connect to Japan",
                                        color = ThemeColor,
                                        modifier = Modifier,
                                        fontWeight = FontWeight.Light,
                                        textAlign = TextAlign.Center
                                    )
                                }


                            }

                        }
                        //下部分
                        Box(
                            modifier = Modifier
                                .weight(1F)
                                .fillMaxWidth(),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 60.dp)
                            ) {

                                //当前节点
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(62.dp)
                                        .padding(vertical = 10.dp)
                                        .border(2.dp, ThemeColor, RoundedCornerShape(8.dp)),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_default_flag),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .width(60.dp)
                                            .height(30.dp)
                                            .padding(horizontal = 10.dp),
                                        tint = Color.Unspecified
                                    )
                                    Text(
                                        text = "America",
                                        color = Color.White,
                                        modifier = Modifier.weight(1F),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_arrow),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .width(28.dp)
                                            .height(16.dp)
                                            .padding(end = 12.dp),
                                        tint = Color.White
                                    )
                                }

                                //链接按钮
                                Button(
                                    onClick = {

                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(62.dp)
                                        .padding(vertical = 10.dp),
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = ThemeColor,
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text(text = "Connect", color = Color.White)
                                }

                                Text(

                                    text = "v1.0",
                                    color = Color.Gray,
                                    modifier = Modifier.fillMaxWidth().padding(top = 0.dp, bottom = 20.dp),
                                    fontSize = 13.sp,
                                    textAlign = TextAlign.Center
                                )

                            }

                        }
                    }

                }
            }
        }
    }
}