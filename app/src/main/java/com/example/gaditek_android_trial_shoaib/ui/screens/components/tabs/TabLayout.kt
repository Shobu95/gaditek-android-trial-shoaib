package com.example.gaditek_android_trial_shoaib.ui.screens.components.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.gaditek_android_trial_shoaib.ui.screens.SocialChannelViewModel
import com.example.gaditek_android_trial_shoaib.ui.screens.state_events.SocialChannelEvent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun TabLayout(viewModel: SocialChannelViewModel) {

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier.background(color = Color.White)
    ) {
        TabBar(pagerState)
        TabViewPager(
            pagerState,
            viewModel.state.socialsList,
            viewModel.state.channelsList
        ) { socialChannelModel ->
            viewModel.onEvent(SocialChannelEvent.onItemClicked(socialChannelModel))
        }
    }
}