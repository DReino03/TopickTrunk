package com.topicktrunck

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.topicktrunck.ui.theme.TopickTrunckTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopickTrunckTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainContent()
                }
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun mainContent(){

    val navController = rememberNavController()
    val destinations = listOf("home","notifications","create","shure","settings")

    Scaffold(
        containerColor = Color.White,
        topBar = { TopAppBar()},
        floatingActionButton = { FAB()},
        bottomBar = {ColorButtonNavBar(navController = navController, destinations = destinations)},
    ){
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen(navController) }
            composable("notifications") { NotificationsScreen() }
            composable("create") { CreateScreen() }
            composable("shure") { ShureScreen() }
            composable("settings") { SettingsScreen() }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    val context = LocalContext.current
    androidx.compose.material3.TopAppBar(

        title = { Box(modifier = Modifier.fillMaxSize()){
            Text(text = "TopickTrunk", color = colorResource(id = R.color.naranja), modifier = Modifier.align(Alignment.Center))
        } },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "Aun no implementado", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Post")
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Aun no implementado", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Profile")
            }
            IconButton(onClick = {
                Toast.makeText(context, "Aun no implementado", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Profile")
            }

        }
    )
}

@Composable
fun FAB(){
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Aun no implementado", Toast.LENGTH_SHORT).show()
    }) {
        Text(text = "X")
    }

}

@Composable
fun RowWithIconButton() {
    val context = LocalContext.current
    val iconState = remember { mutableStateOf(true) }

    Row(modifier = Modifier.padding(4.dp)) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.ThumbUp, contentDescription ="LIKE")
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Share, contentDescription ="Share")
        }
        IconButton(onClick = {
            iconState.value = !iconState.value
        }) {
           Icon(imageVector = if (iconState.value) Icons.Filled.Email else Icons.Default.AccountBox, contentDescription ="Comment")
        }
    }
}

