package com.mavino.dependencyprovider

import com.mavino.filepicker_api.FilePickerApi


object DependencyProvider{

    private lateinit var filePickerApi: FilePickerApi
    fun provideImpl(
        filePickerApi: FilePickerApi
    ) {
        this.filePickerApi = filePickerApi
    }

    fun filePicker(): FilePickerApi = filePickerApi
}


