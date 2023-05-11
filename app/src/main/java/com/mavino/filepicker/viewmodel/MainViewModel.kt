package com.mavino.filepicker.viewmodel

import androidx.lifecycle.ViewModel
import com.mavino.dependencyprovider.DependencyProvider
import com.mavino.filepicker_api.FilePickerApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    val filePickerApi: FilePickerApi
): ViewModel(){
    fun provideImpl(){
        DependencyProvider.provideImpl(
            filePickerApi = filePickerApi,
        )
    }
}