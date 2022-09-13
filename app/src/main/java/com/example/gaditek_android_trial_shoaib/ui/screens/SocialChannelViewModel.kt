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


    var getDataJob: Job? = null

    init {

        getData()
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

    private fun getData() {
        getDataJob?.cancel()
        getDataJob = repository.getSocialChannels().onEach { allList ->
            state = state.copy(
                socialsList = allList.filter { it.type == AppType.SOCIAL },
                channelsList = allList.filter { it.type == AppType.CHANNEL },
                isLoading = false,
                hasError = false,
                hasData = true
            )
            if (allList.isEmpty()) {
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

    override fun onCleared() {
        super.onCleared()
        getDataJob?.cancel()
    }

}