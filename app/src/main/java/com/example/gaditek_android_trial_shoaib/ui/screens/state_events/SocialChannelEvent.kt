package com.example.gaditek_android_trial_shoaib.ui.screens.state_events

import com.example.gaditek_android_trial_shoaib.domain.model.SocialChannelModel

sealed class SocialChannelEvent {
    object onReload : SocialChannelEvent()
    data class onItemClicked(
        val socialChannelModel: SocialChannelModel
    ) : SocialChannelEvent()
}