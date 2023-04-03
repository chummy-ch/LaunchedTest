package com.youarelaunched.challenge.data.repository

import com.youarelaunched.challenge.data.network.api.ApiVendors
import com.youarelaunched.challenge.data.network.models.NetworkCategory
import com.youarelaunched.challenge.data.network.models.NetworkVendor
import com.youarelaunched.challenge.data.repository.model.Vendor
import com.youarelaunched.challenge.data.repository.model.VendorCategory
import com.youarelaunched.challenge.di.DispatcherIo
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.text.Typography.bullet

class VendorsRepositoryImpl @Inject constructor(
    @DispatcherIo private val workDispatcher: CoroutineDispatcher,
    private val api: ApiVendors
) : VendorsRepository {

    override suspend fun getVendors(query: String): List<Vendor> = withContext(workDispatcher) {
        val list = api.getVendors().map {
            it.toVendor()
        }
        filter(query, list)
    }

    private fun filter(query: String, vendors: List<Vendor>): List<Vendor> {
        return if (query.isNotEmpty()) {
            vendors.filter { vendor ->
                vendor.companyName.contains(query, ignoreCase = true)
            }
        } else {
            vendors
        }
    }

    private suspend fun NetworkVendor.toVendor() = coroutineScope {

        val categories = categories?.map {
            async {
                it.toCategory()
            }
        }

        val tags = tags?.let { tagsList ->
            async {
                buildString {
                    tagsList.forEach { tag ->
                        append(bullet)
                        append(" ")
                        append(tag.name)
                        append(" ")
                    }
                }
            }
        }

        Vendor(
            id = id,
            companyName = companyName,
            coverPhoto = coverPhoto.mediaUrl,
            area = areaServed,
            favorite = favorite,
            categories = categories?.awaitAll(),
            tags = tags?.await()
        )
    }

    private fun NetworkCategory.toCategory() =
        VendorCategory(
            id = id,
            title = name,
            imgUrl = image.mediaUrl
        )

}