package com.topicktrunck

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.ContactsContract.Contacts.Photo
import android.provider.MediaStore
import android.view.ViewGroup
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.io.File
import java.util.concurrent.Executor

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@Composable

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
fun CreateScreen() {
    val corrutineScope = rememberCoroutineScope()
    var isShown by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val permissionState = rememberPermissionState(permission = android.Manifest.permission.CAMERA)
    val context = LocalContext.current
    val cameraController = remember {
        LifecycleCameraController(context)
    }
    Spacer(modifier = Modifier.padding(46.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        Text(text = "Crea tu post", color = Color.Black, fontSize = 24.sp)
        Spacer(modifier = Modifier.padding(36.dp))
        var text by remember { mutableStateOf(TextFieldValue("Titulo")) }
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        )
        Spacer(modifier = Modifier.padding(8.dp))
        TextField(
            value = "Escribe aqui la descripcion de tu post",
            onValueChange = { it },
            )
        Row {
            val state = rememberModalBottomSheetState(false)
            TextButton(onClick = {
                corrutineScope.launch {
                    if (isShown) {
                        state.show()
                    } else {
                        state.hide()

                    }
                }
            }) {
                Text("Hazte una foto")
            }
            TextButton(onClick = {
                corrutineScope.launch {
                    if (isShown) {
                        state.show()
                    } else {
                        state.hide()
                    }
                }
            }){
            }
            Row {
                TextButton(onClick = {
                    corrutineScope.launch {
                        if (isShown) {
                            state.show()
                        } else {
                            state.hide()
                        }
                    }
                }) {
                    Text("Selecciona una imagen")
                }
                TextButton(onClick = {
                    corrutineScope.launch {
                        if (isShown) {
                            state.show()
                        } else {
                            state.hide()
                        }
                    }
                }) {



        }


                }
            }
    }
}









