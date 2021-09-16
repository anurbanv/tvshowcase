package com.anurbanv.tvshowcase.ui.episodes.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anurbanv.tvshowcase.App

class EpisodeListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EpisodeListViewModel::class.java)) {
            val repository = App.instance.episodeRepository
            @Suppress("UNCHECKED_CAST")
            return EpisodeListViewModel(repository) as T
        }
        throw IllegalAccessException("Unable to construct ViewModel")
    }
}