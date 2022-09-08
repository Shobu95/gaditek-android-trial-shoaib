package com.example.gaditek_android_trial_shoaib.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SocialChannelResponseDto(
    @SerializedName("header") val header: HeaderDto,
    @SerializedName("body") val body: BodyDto
)

data class HeaderDto(
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
)

data class BodyDto(
    @SerializedName("channels") val channels: List<SocialChannelDto> = emptyList(),
    @SerializedName("socials") val socials: List<SocialChannelDto> = emptyList()
)

data class SocialChannelDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
    @SerializedName("icon_url") val icon: String,
    @SerializedName("package_name_android") val packageName: String,
)


