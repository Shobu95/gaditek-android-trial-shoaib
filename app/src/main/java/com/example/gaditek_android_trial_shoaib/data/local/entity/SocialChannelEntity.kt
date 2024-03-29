package com.example.gaditek_android_trial_shoaib.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gaditek_android_trial_shoaib.domain.enums.AppType
import com.example.gaditek_android_trial_shoaib.domain.model.SocialChannelModel

@Entity(tableName = "social_channel_table")
data class SocialChannelEntity(
    @PrimaryKey
    var name: String,
    var url: String,
    var iconUrl: String,
    var packageName: String,
    var type: AppType
)

fun List<SocialChannelEntity>.asDomainModel(): List<SocialChannelModel> {
    return map {
        SocialChannelModel(
            name = it.name,
            url = it.url,
            iconUrl = it.iconUrl,
            packageName = it.packageName,
            type = it.type
        )
    }
}




