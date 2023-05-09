package com.mavino.filepicker.presentation

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.mavino.filepicker.models.VideoModel
import com.mavino.filepicker.ui.theme.FilePickerTheme
import com.mavino.filepicker.viewmodel.PickerViewModel
import java.util.jar.Manifest
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import coil.compose.rememberImagePainter

class PickerActivity : ComponentActivity() {

    private val context = this@PickerActivity
    private val pickerViewModel: PickerViewModel by viewModels()
    private var contentList: ArrayList<VideoModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkPermissions()
        setContent {
            FilePickerTheme {
                pickerContent(paths = pickerViewModel.loadVideo())
            }
        }
    }

    fun checkPermissions(){
        when {
            ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
            ) == PackageManager.PERMISSION_GRANTED -> {
                pickerViewModel.loadVideo()
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                context,
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
            ) -> {
                ActivityCompat.requestPermissions(
                    context,
                    Array(1) { android.Manifest.permission.READ_EXTERNAL_STORAGE }, 10
                )
            }

            else -> {
                ActivityCompat.requestPermissions(
                    context,
                    Array(1) { android.Manifest.permission.READ_EXTERNAL_STORAGE }, 10
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Composable
//fun content(){
//    Scaffold(
//        content = {
//            PickerContent()
//        }
//    )
//}

@Composable
fun pickerContent(paths: MutableList<String>){
    LazyColumn(
        contentPadding = PaddingValues( horizontal = 16.dp, vertical = 8.dp)
    ){
        itemsIndexed(
            paths
        ){index, item ->  
            PickerImage(path = item )
        }
    }
}
@Composable
fun PickerImage(path: String){
    Image(
        painter = rememberImagePainter(path),
        contentDescription = ""
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FilePickerTheme {
        Greeting("Android")
    }
}