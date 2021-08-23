package com.anurbanv.tvshowcase.util

import android.content.Context
import android.util.Log
import java.io.IOException
import java.nio.charset.Charset

object JsonUtil {

    fun loadJsonFromAssets(context: Context, fileName: String): String {
        var json = ""
        try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.defaultCharset())
        } catch (ex: IOException) {
            // todo use some logger class/library
            Log.e("TVShowCase", "Failed to read json file", ex)
        }

        return json
    }
}