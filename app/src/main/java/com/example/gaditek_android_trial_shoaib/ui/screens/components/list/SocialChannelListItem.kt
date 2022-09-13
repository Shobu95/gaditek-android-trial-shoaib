package com.example.gaditek_android_trial_shoaib.ui.screens.components.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.gaditek_android_trial_shoaib.domain.model.SocialChannelModel

@Composable
fun SocialChannelListItem(
    socialChannel: SocialChannelModel,
    onItemClick: (SocialChannelModel) -> Unit
) {
    Card(
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onItemClick(socialChannel) },
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = rememberAsyncImagePainter(socialChannel.iconUrl),
                contentDescription = "app icon",
                modifier = Modifier
                    .padding(end = 14.dp, start = 6.dp)
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Text(
                text = socialChannel.name,
                style = MaterialTheme.typography.body2,
            )
        }
    }
}
