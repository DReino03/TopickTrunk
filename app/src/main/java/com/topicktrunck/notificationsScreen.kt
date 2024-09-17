package com.topicktrunck

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.topicktrunck.model.navHost


@Composable
fun NotificationsScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            Spacer(modifier = Modifier.height(55.dp))
            Text(text = "Notifications:", color = Color.Black, fontSize = 24.sp,
                modifier = Modifier.padding(8.dp))


        }
        repeat(20) {
            item {
                Row(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .height(65.dp)
                        .background(Color.Gray)
                        .clickable(onClick = {

                        })
                ) {
                      Column(
                          verticalArrangement = Arrangement.Center,
                          modifier = Modifier
                              .fillMaxHeight()
                              .width(18.dp)
                              .background(Color.LightGray)
                      ) {
                          Icon(imageVector = Icons.Filled.Email, contentDescription = "Mail Icon", modifier = Modifier.size(54.dp))
                      }

                      Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.LightGray)
                                .padding(8.dp)

                      ) {
                            Text(text = "Notification $it", color = Color.Black)
                      }
            }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}