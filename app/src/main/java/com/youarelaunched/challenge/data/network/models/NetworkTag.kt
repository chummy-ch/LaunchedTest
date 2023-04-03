package com.youarelaunched.challenge.data.network.models

import com.google.gson.annotations.SerializedName

data class NetworkTag(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("purpose")
    val purpose: String
)
