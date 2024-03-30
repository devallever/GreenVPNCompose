package com.allever.compose.green.vpn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.allever.compose.green.vpn.ui.theme.GreenVPNComposeTheme
import com.allever.compose.green.vpn.ui.theme.PageBgColor
import com.allever.compose.green.vpn.ui.theme.ThemeColor
import com.allever.compose.green.vpn.ui.theme.ThemeColor40
import com.allever.compose.green.vpn.viewmodel.NodeListViewModel

class NodeListPage : ComponentActivity() {
    private val mViewModel: NodeListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreenVPNComposeTheme {
                NodeListContent()
            }
        }
    }

    @Preview
    @Composable
    private fun NodeListContent() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PageBgColor)
        ) {
            TopBar()
            NodeList()
        }
    }

    @Preview
    @Composable
    private fun TopBar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = "",
                modifier = Modifier
                    .rotate(180f)
                    .size(42.dp)
                    .padding(12.dp)
                    .clickable {
                        finish()
                    },
                tint = Color.White
            )

            Text(
                text = "SELECT NODE",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }

    @Preview
    @Composable
    private fun NodeList() {
        val list = mutableListOf<Node>().apply {
            for (i in 0..19) {
                add(Node("Country: $i", i == 0))
            }
        }
        LazyColumn {
            itemsIndexed(list) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(72.dp)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .border(
                            2.dp,
                            if (item.select) ThemeColor else ThemeColor40,
                            RoundedCornerShape(8.dp)
                        ), verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_main),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(90.dp))
                            .padding(10.dp),
                        contentScale = ContentScale.FillWidth
                    )

                    Text(
                        text = item.countryName,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )

                    if (item.select) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_thunder),
                            contentDescription = "",
                            modifier = Modifier
                                .size(42.dp)
                                .padding(10.dp),
                            tint = ThemeColor
                        )
                    }
                }
            }
        }
    }

    data class Node(val countryName: String, var select: Boolean = false)
}