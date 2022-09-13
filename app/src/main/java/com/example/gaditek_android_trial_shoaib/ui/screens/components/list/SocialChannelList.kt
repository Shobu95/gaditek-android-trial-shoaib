package com.example.gaditek_android_trial_shoaib.ui.screens.components.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.gaditek_android_trial_shoaib.domain.model.SocialChannelModel

@Composable
fun SocialChannelList(
    socialChannelList: List<SocialChannelModel>,
    onItemClick: (SocialChannelModel) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .testTag("social_channel_list")
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(socialChannelList) { socialChannel ->
            SocialChannelListItem(
                socialChannel = socialChannel,
                onItemClick = onItemClick
            )
        }
    }

}