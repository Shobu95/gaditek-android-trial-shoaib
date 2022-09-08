package com.example.gaditek_android_trial_shoaib.core.di

import com.example.gaditek_android_trial_shoaib.data.remote.client.RetrofitClient
import com.example.gaditek_android_trial_shoaib.data.remote.client.SocialChannelService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun providesRetrofitClient(): Retrofit {
        return RetrofitClient.retrofit
    }

    @Provides
    @Singleton
    fun providesSocialChannelService(retrofit: Retrofit): SocialChannelService {
        return retrofit.create(SocialChannelService::class.java)
    }
}