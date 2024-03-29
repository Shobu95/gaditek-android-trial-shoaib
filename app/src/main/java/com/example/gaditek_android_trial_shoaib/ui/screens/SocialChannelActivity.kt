package com.example.gaditek_android_trial_shoaib.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.gaditek_android_trial_shoaib.ui.screens.components.error_view.ErrorView
import com.example.gaditek_android_trial_shoaib.ui.screens.components.tabs.TabLayout
import com.example.gaditek_android_trial_shoaib.ui.screens.state_events.SocialChannelEvent
import com.example.gaditek_android_trial_shoaib.ui.theme.TrialAppTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SocialChannelActivity : ComponentActivity() {

    private val viewModel by viewModels<SocialChannelViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrialAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainAppBody(viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainAppBody(viewModel: SocialChannelViewModel) {

    Box(contentAlignment = Alignment.Center) {

        if (viewModel.state.isLoading) {
            CircularProgressIndicator()
        }

        if (viewModel.state.hasData) {
            TabLayout(
                socialList = viewModel.state.socialsList,
                channelList = viewModel.state.channelsList
            ) { socialChannelModel ->
                viewModel.onEvent(SocialChannelEvent.onItemClicked(socialChannelModel))
            }
        }

        if (viewModel.state.hasError) {
            ErrorView { viewModel.onEvent(SocialChannelEvent.onReload) }
        }

    }

}
