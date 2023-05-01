package com.mavino.filepicker.usecases

import android.content.Context
import android.provider.MediaStore
import javax.inject.Inject


class VideoPicker
@Inject
constructor(
    val context: Context
) {
    private val filesPaths = mutableListOf<String>()

    fun getVideos(page: Int, pageSize: Int){
        var pageCount = page
        val projection = arrayOf(MediaStore.Video.Media.DATA, MediaStore.Video.Media.DATE_TAKEN)
        val selection = "${MediaStore.Video.Media.SIZE} > 0"
        val sortOrder = "${MediaStore.Video.Media.DATE_MODIFIED} DESC"
        val offset = (page - 1) * pageSize
        val limit = pageSize.toString()
        val uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI.buildUpon()
            .appendQueryParameter("limit", limit)
            .appendQueryParameter("offset", offset.toString())
            .build()

        val cursor =
            context.contentResolver.query(uri, projection, selection, null, sortOrder)

        cursor?.let {
            while (it.moveToNext()) {
                val videoPath = it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.DATA))
                val dateTaken =
                    it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_TAKEN))
                filesPaths.add(videoPath)
            }
            it.close()
            pageCount++
        }
    }
}