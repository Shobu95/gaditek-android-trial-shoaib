package com.example.gaditek_android_trial_shoaib.data.repository

import com.example.gaditek_android_trial_shoaib.domain.model.SocialChannelModel
import kotlinx.coroutines.flow.Flow

interface SocialChannelRepository {

    fun getSocialChannels(): Flow<List<SocialChannelModel>>

    suspend fun refreshSocialChannels()
}