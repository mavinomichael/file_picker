package com.mavino.dependencyprovider

import com.mavino.filepicker_api.FilePickerApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DependencyModule {

    @Binds
    fun bindPickerFeature(): FilePickerApi
}