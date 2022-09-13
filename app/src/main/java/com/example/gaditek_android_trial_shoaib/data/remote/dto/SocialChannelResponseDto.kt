package com.example.gaditek_android_trial_shoaib.data.remote.dto

import com.example.gaditek_android_trial_shoaib.data.local.entity.SocialChannelEntity
import com.example.gaditek_android_trial_shoaib.domain.enums.AppType
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

fun BodyDto.channelsAsDatabaseModel(): List<SocialChannelEntity> {
    return channels.map {
        SocialChannelEntity(
            name = it.name,
            url = it.url,
            iconUrl = it.icon,
            packageName = it.packageName,
            type = AppType.CHANNEL
        )
    }
}

fun BodyDto.socialsAsDatabaseModel(): List<SocialChannelEntity> {
    return socials.map {
        SocialChannelEntity(
            name = it.name,
            url = it.url,
            iconUrl = it.icon,
            packageName = it.packageName,
            type = AppType.SOCIAL
        )
    }
}


