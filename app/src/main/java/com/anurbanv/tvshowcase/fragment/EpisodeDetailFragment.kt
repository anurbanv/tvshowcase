package com.anurbanv.tvshowcase.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.anurbanv.tvshowcase.R
import com.anurbanv.tvshowcase.databinding.FragmentEpisodeDetailBinding
import com.anurbanv.tvshowcase.entity.Episode
import com.bumptech.glide.Glide

class EpisodeDetailFragment : Fragment(R.layout.fragment_episode_detail) {

    lateinit var episode: Episode
    var onBackClick: () -> Unit = {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentEpisodeDetailBinding.bind(view)

        // todo make button more visible to user
        binding.btnBack.setOnClickListener { onBackClick() }

        binding.tvSeason.text = "Season ${episode.season}"
        binding.tvEpisode.text = "Episode ${episode.number}"
        binding.tvName.text = episode.name
        binding.tvSummary.text = episode.summary

        Glide.with(this).load(episode.imageUrl)
            .centerCrop().into(binding.ivCover)
    }
}