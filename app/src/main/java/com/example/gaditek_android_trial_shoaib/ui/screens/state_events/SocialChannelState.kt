package com.example.gaditek_android_trial_shoaib.ui.screens.state_events

import com.example.gaditek_android_trial_shoaib.domain.model.SocialChannelModel

data class SocialChannelState(
    val socialsList: List<SocialChannelModel> = emptyList(),
    val channelsList: List<SocialChannelModel> = emptyList(),
    val inProgress: Boolean = false,
    val hasError: Boolean = false,
    val hasData: Boolean = false
)
