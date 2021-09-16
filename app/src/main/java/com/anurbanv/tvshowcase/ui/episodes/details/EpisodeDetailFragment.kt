package com.anurbanv.tvshowcase.ui.episodes.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.anurbanv.tvshowcase.databinding.FragmentEpisodeDetailBinding
import com.bumptech.glide.Glide

class EpisodeDetailFragment : Fragment() {

    private lateinit var binding: FragmentEpisodeDetailBinding
    private val args: EpisodeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val episode = args.episode

        binding.tvSeason.text = "Season ${episode.seasonNr}"
        binding.tvEpisode.text = "Episode ${episode.episodeNr}"
        binding.tvName.text = episode.title
        binding.tvSummary.text = episode.plot

        Glide.with(this).load(episode.posterUrl).centerCrop().into(binding.ivCover)
    }
}