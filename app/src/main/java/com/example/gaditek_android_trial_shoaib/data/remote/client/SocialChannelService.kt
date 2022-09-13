package com.example.gaditek_android_trial_shoaib.data.remote.client

import com.example.gaditek_android_trial_shoaib.data.remote.dto.SocialChannelResponseDto
import retrofit2.http.GET

interface SocialChannelService {
    @GET("android/premium/channels-socials.json")
    suspend fun getSocialChannels(): SocialChannelResponseDto
}