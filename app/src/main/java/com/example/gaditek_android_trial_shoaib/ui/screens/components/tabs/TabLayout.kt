package com.example.gaditek_android_trial_shoaib.ui.screens.components.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun TabLayout() {

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier.background(color = Color.White)
    ) {
        TabBar(pagerState)
        TabViewPager(pagerState)
    }
}