package com.anurbanv.tvshowcase

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.anurbanv.tvshowcase.databinding.ActivityMainBinding
import com.anurbanv.tvshowcase.fragment.EpisodeListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var episodeListFragment: EpisodeListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (savedInstanceState == null) {
            episodeListFragment = EpisodeListFragment()
        }

        showEpisodeListFragment()
    }

    private fun showEpisodeListFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainerView, episodeListFragment)
        }
    }
}