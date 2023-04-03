package com.youarelaunched.challenge.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DispatcherIo

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DispatcherDefault

@Module
@InstallIn(SingletonComponent::class)
internal object CoroutineDispatcherModule {

    @Provides
    @DispatcherIo
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @DispatcherDefault
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

}