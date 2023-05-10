package com.mavino.filepicker.di

import android.content.Context
import com.mavino.filepicker.usecases.VideoPicker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@InstallIn(ViewModelComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideVideoPicker(@ApplicationContext context: Context): VideoPicker{
        return VideoPicker(
            context = context
        )
    }
}