package com.anurbanv.tvshowcase.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.anurbanv.tvshowcase.R
import com.anurbanv.tvshowcase.databinding.FragmentEpisodeDetailBinding
import com.anurbanv.tvshowcase.entity.Episode

class EpisodeDetailFragment : Fragment(R.layout.fragment_episode_detail) {

    lateinit var episode: Episode

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentEpisodeDetailBinding.bind(view)
    }
}