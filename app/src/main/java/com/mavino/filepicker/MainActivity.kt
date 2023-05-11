package com.mavino.filepicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.mavino.filepicker.navigation.AppNavGraph
import com.mavino.filepicker.ui.theme.FilePickerTheme
import com.mavino.filepicker.ui.theme.Pink80
import com.mavino.filepicker.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.provideImpl()

        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    ProvideWindowInsets {
        FilePickerTheme() {
            val navController = rememberNavController()
            Scaffold(
                backgroundColor = Pink80,
            ) { innerPaddingModifier ->
                AppNavGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPaddingModifier)
                )
            }
        }
    }
}
