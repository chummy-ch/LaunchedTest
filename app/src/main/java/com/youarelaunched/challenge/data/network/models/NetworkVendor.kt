package com.youarelaunched.challenge.data.network.models


import com.google.gson.annotations.SerializedName

data class NetworkVendor(
    @SerializedName("area_served")
    val areaServed: String,
    @SerializedName("categories")
    val categories: List<NetworkCategory>?,
    @SerializedName("company_name")
    val companyName: String,
    @SerializedName("cover_photo")
    val coverPhoto: NetworkMediaAttachment,
    @SerializedName("profile_photo")
    val profilePhoto: NetworkMediaAttachment?,
    @SerializedName("distance")
    val distance: Double?,
    @SerializedName("favorited")
    val favorite: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("shop_type")
    val shopType: String,
    @SerializedName("tags")
    val tags: List<NetworkTag>?,
    @SerializedName("chat_id")
    val chatId: Int?,
    @SerializedName("business_type")
    val type: String?
)