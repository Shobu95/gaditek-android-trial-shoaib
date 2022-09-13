package com.example.gaditek_android_trial_shoaib.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gaditek_android_trial_shoaib.data.repository.SocialChannelRepository
import com.example.gaditek_android_trial_shoaib.domain.use_case.SocialChannelUseCase
import com.example.gaditek_android_trial_shoaib.ui.screens.state_events.SocialChannelEvent
import com.example.gaditek_android_trial_shoaib.ui.screens.state_events.SocialChannelState
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class SocialChannelViewModel @Inject constructor(
    private val repository: SocialChannelRepository,
    private val useCase: SocialChannelUseCase
) : ViewModel() {

    var state by mutableStateOf(SocialChannelState())
        private set

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
                useCase.invoke(event.socialChannelModel)
            }
        }
    }

    private fun getSocials() {
        viewModelScope.launch {
            repository.getSocials().onEach { socials ->
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
            }
        }
    }

    private fun getChannels() {
        viewModelScope.launch {
            repository.getChannels().onEach { channels ->
                state = state.copy(
                    socialsList = channels,
                    isLoading = false,
                    hasError = false,
                    hasData = true
                )
                if (channels.isEmpty()) {
                    state = state.copy(
                        hasData = false
                    )
                }
            }
        }
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