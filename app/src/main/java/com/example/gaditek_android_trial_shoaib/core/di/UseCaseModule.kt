package com.example.gaditek_android_trial_shoaib.core.di

import android.app.Application
import com.example.gaditek_android_trial_shoaib.domain.use_case.SocialChannelUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun providesActionUseCase(context: Application): SocialChannelUseCase {
        return SocialChannelUseCase(context)
    }
}