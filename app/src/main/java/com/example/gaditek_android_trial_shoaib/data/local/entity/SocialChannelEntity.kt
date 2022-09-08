package com.example.gaditek_android_trial_shoaib.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SocialChannelEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var iconUrl: String,
    var packageName: String
)

