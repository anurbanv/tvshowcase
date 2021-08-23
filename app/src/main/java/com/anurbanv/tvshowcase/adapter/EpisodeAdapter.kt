package com.anurbanv.tvshowcase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anurbanv.tvshowcase.databinding.ItemEpisodeBinding
import com.anurbanv.tvshowcase.entity.Episode
import com.bumptech.glide.Glide

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    var episodeList: List<Episode> = emptyList()
        set(value) {
            field = value
            // todo implement notify by item changed
            notifyDataSetChanged()
        }

    class ViewHolder(val binding: ItemEpisodeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodeBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val episode = episodeList[position]

        holder.binding.tvName.text = episode.name
        Glide.with(holder.binding.root).load(episode.imageUrl)
            .centerCrop().into(holder.binding.ivCover)
    }

    override fun getItemCount() = episodeList.size
}