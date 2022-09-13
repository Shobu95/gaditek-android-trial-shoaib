package com.example.gaditek_android_trial_shoaib.core.di

import com.example.gaditek_android_trial_shoaib.data.repository.SocialChannelRepository
import com.example.gaditek_android_trial_shoaib.data.repository.SocialChannelRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class MyRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @MyRepositoryImpl
    @Singleton
    @Binds
    abstract fun bindSocialChannelRepositoryImpl(
        repositoryImpl: SocialChannelRepositoryImpl,
    ): SocialChannelRepository
}