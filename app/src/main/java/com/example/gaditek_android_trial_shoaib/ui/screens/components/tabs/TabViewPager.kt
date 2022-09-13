package com.example.gaditek_android_trial_shoaib.ui.screens.components.tabs

import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
@Composable
fun TabViewPager(pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        count = 2
    ) { page ->
        when (page) {
//            0 -> SocialChannelList()
//            1 -> SocialChannelList()
        }
    }
}