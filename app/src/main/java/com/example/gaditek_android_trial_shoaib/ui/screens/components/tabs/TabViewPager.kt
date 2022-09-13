package com.example.gaditek_android_trial_shoaib.ui.screens.components.tabs

import androidx.compose.runtime.Composable
import com.example.gaditek_android_trial_shoaib.domain.model.SocialChannelModel
import com.example.gaditek_android_trial_shoaib.ui.screens.components.list.SocialChannelList
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
@Composable
fun TabViewPager(
    pagerState: PagerState,
    socialsList: List<SocialChannelModel>,
    channelsList: List<SocialChannelModel>,
    onItemClicked: (SocialChannelModel) -> Unit
) {
    HorizontalPager(
        state = pagerState,
        count = 2
    ) { page ->
        when (page) {
            0 -> {
                SocialChannelList(channelsList) { socialChannelModel ->
                    onItemClicked(
                        socialChannelModel
                    )
                }
            }
            1 -> {
                SocialChannelList(socialsList) { socialChannelModel ->
                    onItemClicked(
                        socialChannelModel
                    )
                }
            }
        }
    }
}