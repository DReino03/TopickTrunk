package com.topicktrunck

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen() {
    Spacer(modifier = Modifier.height(36.dp))
    val sheetState = rememberModalBottomSheetState()
    Text(text = "Settings", color = Color.Black)
    Column {
        Row(modifier = Modifier.clickable { sheetState }) {
            Text(text = "Language", color = Color.Black)
        }
    }
}

@Composable
fun StyleText(){
    Text(text = "Settings", color = Color.Black)
    /*
    Quiero que esta función devuelva un un dropdown con las opciones de configuración de el texto en la app
     */
    val styleTextList = listOf("Bold", "Italic", "Underline", "Normal")
    val sizeTextList = listOf("Small", "Medium", "Large")
    val colorTextList = listOf("Black", "White", "Red", "Blue", "Green", "Yellow")


}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun modalBottom(){
    val state = rememberModalBottomSheetState()
    ModalBottomSheet(
        sheetState = state,
        onDismissRequest = { /*TODO*/ })
    {
        Column {
            Text(text = "Settings", color = Color.Black)
            TextButton(onClick = { /*TODO*/ }) {
                Text("Bold")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text("Italic")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text("Underline")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text("Normal")
            }
        }
    }
}


