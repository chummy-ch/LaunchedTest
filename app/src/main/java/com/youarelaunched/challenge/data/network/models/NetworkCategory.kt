package com.youarelaunched.challenge.data.network.models


import com.google.gson.annotations.SerializedName

data class NetworkCategory(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: NetworkMediaAttachment,
    @SerializedName("name")
    val name: String
)