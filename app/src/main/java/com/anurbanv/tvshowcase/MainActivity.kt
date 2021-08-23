package com.anurbanv.tvshowcase

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.anurbanv.tvshowcase.adapter.EpisodeAdapter
import com.anurbanv.tvshowcase.databinding.ActivityMainBinding
import com.anurbanv.tvshowcase.entity.Episode
import com.anurbanv.tvshowcase.util.JsonUtil
import com.google.gson.Gson
import com.google.gson.JsonObject

class MainActivity : AppCompatActivity() {

    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val adapter = EpisodeAdapter()

        binding.rvEpisodes.layoutManager = LinearLayoutManager(this)
        binding.rvEpisodes.adapter = adapter

        val episodeList = parseEpisodesJson()
        adapter.episodeList = episodeList
    }

    private fun parseEpisodesJson(): List<Episode> {
        val episodeList = arrayListOf<Episode>()

        val jsonString = JsonUtil.loadJsonFromAssets(this, "hbo-silicon-valley.json")
        val fromJson = gson.fromJson(jsonString, JsonObject::class.java)

        for (seasonJson in fromJson.get("seasons").asJsonArray) {
            for (episodeJson in seasonJson.asJsonObject.get("episodes").asJsonArray) {
                val season = episodeJson.asJsonObject.get("Season").asInt
                val episodeNr = episodeJson.asJsonObject.get("Episode").asInt
                val name = episodeJson.asJsonObject.get("Title").asString
                val imageUrl = episodeJson.asJsonObject.get("Poster").asString
                val summary = episodeJson.asJsonObject.get("Plot").asString

                episodeList.add(Episode(season, episodeNr, name, imageUrl, summary))
            }
        }

        return episodeList
    }
}