package com.mavino.filepicker.models

data class VideoModel(
    val filePath: String,
    val fileName: String,
    val duration: String,
    val mimeType: String,
    val resolution: String,
    val captureFrameRate: String,
    val orientation: String,
    val dataAdded: String,
    val dataModified: String,
    val dataTaken: String
)
