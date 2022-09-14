package com.example.gaditek_android_trial_shoaib.data.remote.service

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gaditek_android_trial_shoaib.data.remote.client.SocialChannelService
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.greaterThan
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.annotation.Config
import javax.inject.Inject

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SocialChannelServiceTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var service: SocialChannelService

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun `1- social channel service instance should not be null`() {
        assertThat(service, notNullValue())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `2- service should return non-null response`() = runBlocking {
        val response = service.getSocialChannels()
        assertThat(response, notNullValue())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `3- service should contain lists of channels and social apps`() = runBlocking {
        val response = service.getSocialChannels()

        Assert.assertNotNull(response.body.channels)
        assertThat(response.body.channels.size, greaterThan(0))

        Assert.assertNotNull(response.body.socials)
        assertThat(response.body.channels.size, greaterThan(0))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `4- first item of channels list should have all values`() = runBlocking {
        val response = service.getSocialChannels()
        val channelObj = response.body.channels[0]
        assertThat(channelObj.name, notNullValue())
        assertThat(channelObj.url, notNullValue())
        assertThat(channelObj.icon, notNullValue())
        assertThat(channelObj.packageName, notNullValue())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `5- first item of socials list should have all values`() = runBlocking {
        val response = service.getSocialChannels()
        val socialObj = response.body.socials[0]
        assertThat(socialObj.name, notNullValue())
        assertThat(socialObj.url, notNullValue())
        assertThat(socialObj.icon, notNullValue())
        assertThat(socialObj.packageName, notNullValue())
    }

}