package com.mavino.filepicker.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mavino.filepicker.presentation.PickerScreen
import com.mavino.filepicker_api.FilePickerApi

private const val baseRoute = "home"

class FilePickerImpl : FilePickerApi {

    override val pickerRoute = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute){
            PickerScreen()
        }
    }

}