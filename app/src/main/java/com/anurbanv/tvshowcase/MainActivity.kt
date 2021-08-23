package com.anurbanv.tvshowcase

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.anurbanv.tvshowcase.databinding.ActivityMainBinding
import com.anurbanv.tvshowcase.fragment.EpisodeDetailFragment
import com.anurbanv.tvshowcase.fragment.EpisodeListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var episodeListFragment: EpisodeListFragment
    private lateinit var episodeDetailFragment: EpisodeDetailFragment
    private var overrideBackButton = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (savedInstanceState == null) {
            episodeListFragment = EpisodeListFragment()
            episodeListFragment.onItemClicked = {
                episodeDetailFragment.episode = it
                showEpisodeDetailFragment()
            }

            episodeDetailFragment = EpisodeDetailFragment()
        }

        showEpisodeListFragment()
    }

    private fun showEpisodeListFragment() {
        overrideBackButton = false
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainerView, episodeListFragment)
        }
    }

    private fun showEpisodeDetailFragment() {
        overrideBackButton = true
        // todo add fragment transition animation
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainerView, episodeDetailFragment)
        }
    }

    override fun onBackPressed() {
        if (overrideBackButton) {
            showEpisodeListFragment()
        } else {
            super.onBackPressed()
        }
    }
}