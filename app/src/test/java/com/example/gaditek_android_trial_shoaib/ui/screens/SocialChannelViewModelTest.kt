package com.example.gaditek_android_trial_shoaib.ui.screens

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gaditek_android_trial_shoaib.core.di.MyRepositoryImpl
import com.example.gaditek_android_trial_shoaib.data.repository.SocialChannelRepository
import com.example.gaditek_android_trial_shoaib.domain.use_case.SocialChannelUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.annotation.Config
import javax.inject.Inject

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SocialChannelViewModelTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var useCase: SocialChannelUseCase

    @Inject
    @MyRepositoryImpl
    lateinit var repository: SocialChannelRepository

    lateinit var viewModel: SocialChannelViewModel

    @Before
    fun init() {
        hiltRule.inject()
        viewModel = SocialChannelViewModel(repository, useCase)
    }

    @Test
    fun `1- viewmodel instance should be initialized`() {
        Assert.assertNotNull(viewModel)
    }
}