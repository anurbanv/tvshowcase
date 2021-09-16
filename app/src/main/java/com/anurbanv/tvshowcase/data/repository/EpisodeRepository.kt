package com.anurbanv.tvshowcase.data.repository

import android.content.Context
import com.anurbanv.tvshowcase.data.TvShow
import com.anurbanv.tvshowcase.data.util.JsonUtil
import com.google.gson.Gson

class EpisodeRepository(context: Context, private val gson: Gson) {

    companion object {
        const val JSON_FILE_NAME = "hbo-silicon-valley.json"
    }

    private val appContext = context.applicationContext

    fun getTvShow(): TvShow {
        // todo use room to cache data
        val jsonString = JsonUtil.loadJsonFromAssets(appContext, JSON_FILE_NAME)
        return gson.fromJson(jsonString, TvShow::class.java)
    }
}