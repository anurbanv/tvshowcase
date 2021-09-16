package com.anurbanv.tvshowcase.ui.episodes.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anurbanv.tvshowcase.data.repository.EpisodeRepository
import com.anurbanv.tvshowcase.data.Episode
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.withContext

class EpisodeListViewModel(private val repository: EpisodeRepository) : ViewModel() {

    private val episodeList = MutableLiveData<List<Episode>>()
    private val showTitle = MutableLiveData<String>()

    suspend fun loadSeasons() {
        val tvShow = repository.getTvShow()
        val episodes = mutableListOf<Episode>()

        tvShow.seasons.forEach { episodes.addAll(it.episodes) }

        withContext(Main) {
            episodeList.value = episodes
            showTitle.value = tvShow.title
        }
    }

    fun getEpisodeList(): LiveData<List<Episode>> = episodeList

    fun getShowTitle(): LiveData<String> = showTitle
}