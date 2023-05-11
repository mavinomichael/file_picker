package com.mavino.filepicker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.mavino.dependencyprovider.DependencyProvider
import com.mavino.feature_api.register
import com.mavino.filepicker_api.FilePickerApi
import javax.inject.Inject

@Composable
@Inject
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = DependencyProvider.filePicker().pickerRoute
    ){

        register(
            DependencyProvider.filePicker(),
            navController = navController,
            modifier = modifier
        )
    }
}