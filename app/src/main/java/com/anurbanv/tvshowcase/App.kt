package com.anurbanv.tvshowcase

import android.app.Application
import com.anurbanv.tvshowcase.data.repository.EpisodeRepository
import com.google.gson.Gson

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    // todo use DI
    lateinit var episodeRepository: EpisodeRepository
    lateinit var gson: Gson

    override fun onCreate() {
        super.onCreate()
        instance = this

        gson = Gson()
        episodeRepository = EpisodeRepository(this, gson)
    }
}