package com.youarelaunched.challenge.data.repository.model

data class Vendor(
    val id: Int,
    val companyName: String,
    val coverPhoto: String,
    val area: String,
    val favorite: Boolean,
    val categories: List<VendorCategory>?,
    val tags: String?
)