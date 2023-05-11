package com.mavino.filepicker.di

import com.mavino.filepicker_api.FilePickerApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun bindPickerFeature(): FilePickerApi
}