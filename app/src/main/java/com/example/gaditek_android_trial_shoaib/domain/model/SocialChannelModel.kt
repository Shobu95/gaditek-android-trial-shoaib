package com.example.gaditek_android_trial_shoaib.domain.model

import com.example.gaditek_android_trial_shoaib.domain.enums.AppType

data class SocialChannelModel(
    var name: String,
    var url: String,
    var iconUrl: String,
    var packageName: String,
    var type: AppType
)
