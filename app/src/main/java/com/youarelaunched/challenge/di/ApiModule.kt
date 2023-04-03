package com.youarelaunched.challenge.di

import com.youarelaunched.challenge.data.network.api.ApiVendors
import com.youarelaunched.challenge.data.network.api.NetworkDataProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface ApiModule {

    @Binds
    fun bindApi(impl: NetworkDataProvider): ApiVendors
}