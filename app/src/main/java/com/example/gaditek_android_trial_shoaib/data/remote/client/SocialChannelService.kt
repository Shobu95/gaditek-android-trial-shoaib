package com.example.gaditek_android_trial_shoaib.data.remote.client

import com.example.gaditek_android_trial_shoaib.data.remote.dto.SocialChannelResponseDto
import retrofit2.http.GET

interface SocialChannelService {
    @GET("search/repositories?q=language=+sort:stars")
    suspend fun getTrendingRepos(): SocialChannelResponseDto
}