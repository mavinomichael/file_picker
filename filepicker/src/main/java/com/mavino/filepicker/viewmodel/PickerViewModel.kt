package com.mavino.filepicker.viewmodel

import androidx.lifecycle.ViewModel
import com.mavino.filepicker.usecases.VideoPicker
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PickerViewModel @Inject constructor(
    private val videoPicker: VideoPicker
): ViewModel() {

    fun loadVideo(): MutableList<String>{
       return videoPicker.getVideos()
    }
}