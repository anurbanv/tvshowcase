package com.anurbanv.tvshowcase.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anurbanv.tvshowcase.R
import com.anurbanv.tvshowcase.adapter.EpisodeAdapter
import com.anurbanv.tvshowcase.databinding.FragmentEpisodeListBinding
import com.anurbanv.tvshowcase.entity.Episode
import com.anurbanv.tvshowcase.util.JsonUtil
import com.google.gson.Gson
import com.google.gson.JsonObject

class EpisodeListFragment : Fragment(R.layout.fragment_episode_list) {

    private val gson = Gson()
    var onItemClicked: (Episode) -> Unit = {}
    lateinit var title: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentEpisodeListBinding.bind(view)

        val adapter = EpisodeAdapter()
        adapter.onItemClicked = onItemClicked

        binding.rvEpisodes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvEpisodes.adapter = adapter

        val episodeList = parseEpisodesJson()
        adapter.episodeList = episodeList

        binding.tvTitle.text = title
    }

    private fun parseEpisodesJson(): List<Episode> {
        val episodeList = arrayListOf<Episode>()

        val jsonString = JsonUtil.loadJsonFromAssets(requireContext(), "hbo-silicon-valley.json")
        val fromJson = gson.fromJson(jsonString, JsonObject::class.java)

        title = fromJson.get("title").asString

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