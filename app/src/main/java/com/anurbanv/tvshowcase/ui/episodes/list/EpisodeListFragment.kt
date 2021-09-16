package com.anurbanv.tvshowcase.ui.episodes.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.anurbanv.tvshowcase.ui.adapter.EpisodeAdapter
import com.anurbanv.tvshowcase.databinding.FragmentEpisodeListBinding
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EpisodeListFragment : Fragment() {

    private val viewModel by viewModels<EpisodeListViewModel> { EpisodeListViewModelFactory() }

    private lateinit var binding: FragmentEpisodeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val episodeAdapter = EpisodeAdapter()

        episodeAdapter.onItemClicked = {
            val action = EpisodeListFragmentDirections.showEpisodeDetails(it)
            Navigation.findNavController(view).navigate(action)
        }

        with(binding.rvEpisodes) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }

        lifecycleScope.launch {
            viewModel.loadSeasons()
            withContext(Main) {
                viewModel.getEpisodeList().observe(viewLifecycleOwner, {
                    episodeAdapter.episodeList = it
                })
                viewModel.getShowTitle().observe(viewLifecycleOwner, {
                    binding.tvTitle.text = it
                })
            }
        }
    }
}