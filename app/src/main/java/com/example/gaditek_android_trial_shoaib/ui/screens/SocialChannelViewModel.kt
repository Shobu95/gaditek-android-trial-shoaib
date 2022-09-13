package com.example.gaditek_android_trial_shoaib.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gaditek_android_trial_shoaib.core.di.MyRepositoryImpl
import com.example.gaditek_android_trial_shoaib.data.repository.SocialChannelRepository
import com.example.gaditek_android_trial_shoaib.domain.enums.AppType
import com.example.gaditek_android_trial_shoaib.domain.use_case.SocialChannelUseCase
import com.example.gaditek_android_trial_shoaib.ui.screens.state_events.SocialChannelEvent
import com.example.gaditek_android_trial_shoaib.ui.screens.state_events.SocialChannelState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SocialChannelViewModel
@Inject constructor(
    @MyRepositoryImpl
    private val repository: SocialChannelRepository,
    private val actionUseCase: SocialChannelUseCase
) : ViewModel() {

    var state by mutableStateOf(SocialChannelState())
        private set

    var getChannelsJob: Job? = null
    var getSocialsJob: Job? = null

    init {
        getChannels()
        getSocials()
        refreshData()
    }

    fun onEvent(event: SocialChannelEvent) {
        when (event) {

            is SocialChannelEvent.onReload -> {
                refreshData()
            }

            is SocialChannelEvent.onItemClicked -> {
                actionUseCase.invoke(event.socialChannelModel)
            }
        }
    }

    private fun getSocials() {
        getSocialsJob?.cancel()
        getSocialsJob = repository.getSocialChannels(AppType.SOCIAL).onEach { socials ->
            state = state.copy(
                socialsList = socials,
                isLoading = false,
                hasError = false,
                hasData = true
            )
            if (socials.isEmpty()) {
                state = state.copy(
                    hasData = false
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun getChannels() {
        getChannelsJob?.cancel()
        getChannelsJob = repository.getSocialChannels(AppType.CHANNEL).onEach { channels ->
            state = state.copy(
                channelsList = channels,
                isLoading = false,
                hasError = false,
                hasData = true
            )
            if (channels.isEmpty()) {
                state = state.copy(
                    hasData = false
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun refreshData() {
        state = state.copy(
            isLoading = true,
            hasError = false
        )
        viewModelScope.launch {
            try {
                repository.refreshSocialChannels()
            } catch (e: Exception) {
                state = state.copy(
                    isLoading = false,
                    hasError = true
                )
            }
        }
    }

}