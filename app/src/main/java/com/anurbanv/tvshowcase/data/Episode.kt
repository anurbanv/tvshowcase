package com.anurbanv.tvshowcase.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Episode(
    @SerializedName("Episode")
    val episodeNr: Int,

    @SerializedName("Plot")
    val plot: String,

    @SerializedName("Poster")
    val posterUrl: String,

    @SerializedName("Season")
    val seasonNr: String,

    @SerializedName("Title")
    val title: String,
) : Parcelable