package com.youarelaunched.challenge.data.network.models


import com.google.gson.annotations.SerializedName

data class NetworkMediaAttachment(
    @SerializedName("id")
    val id: Int,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("media_url")
    val mediaUrl: String
)