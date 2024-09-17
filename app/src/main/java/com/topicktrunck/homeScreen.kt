package com.topicktrunck

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    HomeContent()
}


@Composable
fun HomeContent() {
    var context = LocalContext.current
    LazyColumn {

        item{
            Spacer(modifier = Modifier.padding(38.dp))
        }
        items(5) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),

                ) {
                Column(modifier = Modifier.padding(4.dp)) {
                    Row(modifier = Modifier.padding(2.dp)) {
                        Row(modifier = Modifier.padding(8.dp)) {
                            Image(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription ="")
                            Spacer(modifier = Modifier.padding(8.dp))
                            Text(text = "Persona $it", modifier = Modifier.align(Alignment.CenterVertically))
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(onClick = { /*TODO*/ } ) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More" )
                        }
                    }

                    Row(modifier = Modifier.padding(8.dp)) {
                        Text(text = "Esta es una bombilla muy bonita, que ilumina mucho",)
                    }
                    Row(modifier = Modifier.padding(8.dp)) {
                        Image(painter = painterResource(id = R.drawable.bombilla), contentDescription = "" )
                    }
                    Row(modifier = Modifier.padding(4.dp)) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.ThumbUp, contentDescription ="LIKE")
                        }

                        IconButton(onClick = {
                            val text = "Compartir"
                            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                                putExtra(Intent.EXTRA_TEXT, text)
                                type = "text/plain"
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            context.startActivity(shareIntent)
                        }) {
                            Icon(imageVector = Icons.Filled.Share, contentDescription ="Share")
                        }

                    }
                }

            }
        }
    }
}


@Composable
fun Share(text: String, context: Context) {

}