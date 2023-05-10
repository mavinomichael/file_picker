package com.mavino.filepicker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.mavino.feature_api.register
import com.mavino.filepicker_api.FilePickerApi
import javax.inject.Inject

@Composable
@Inject
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    pickerApi: FilePickerApi
) {

    NavHost(
        navController = navController,
        startDestination = pickerApi.pickerRoute
    ){

//        register(
//            ,
//            navController = navController,
//            modifier = modifier
//        )
    }
}