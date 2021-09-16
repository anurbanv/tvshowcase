package com.anurbanv.tvshowcase.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anurbanv.tvshowcase.data.Episode
import com.anurbanv.tvshowcase.databinding.ItemEpisodeBinding
import com.bumptech.glide.Glide

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    var episodeList: List<Episode> = emptyList()
        set(value) {
            field = value
            // todo implement notify by item changed
            notifyDataSetChanged()
        }

    var onItemClicked: (Episode) -> Unit = {}

    class ViewHolder(val binding: ItemEpisodeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodeBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val episode = episodeList[position]

        holder.binding.tvName.text = episode.title
        // todo extract to string resource
        holder.binding.tvSeason.text = "Season ${episode.seasonNr}"
        holder.binding.tvEpisode.text = "Episode ${episode.episodeNr}"

        holder.binding.ivCover.clipToOutline = true

        Glide.with(holder.binding.root).load(episode.posterUrl)
            .centerCrop().into(holder.binding.ivCover)

        holder.binding.root.setOnClickListener { onItemClicked(episode) }
    }

    override fun getItemCount() = episodeList.size
}