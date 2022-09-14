package com.example.gaditek_android_trial_shoaib.data.local.database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gaditek_android_trial_shoaib.data.local.entity.SocialChannelEntity
import com.example.gaditek_android_trial_shoaib.domain.enums.AppType
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.annotation.Config
import javax.inject.Inject


@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SocialChannelDbTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var db: SocialChannelDb

    @Inject
    lateinit var dao: SocialChannelDao

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun `1- should initialize database`() {
        assertThat(db, notNullValue())
    }

    @Test
    fun `2- should initialize dao object`() {
        assertThat(dao, notNullValue())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `3- should insert a social app and read it`() = runTest {
        val socialApp = SocialChannelEntity(
            name = "Facebook",
            url = "some random url",
            iconUrl = "some icon url",
            packageName = "some package name",
            type = AppType.SOCIAL
        )

        val appList = listOf(socialApp)

        CoroutineScope(Dispatchers.IO).launch {
            dao.insertAll(appList)
            val testSocialApp = dao.getSocialChannels().first()[0]
            assertEquals(testSocialApp.name, socialApp.name)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `4- conflicting strategy should replace duplicate object`() {

        val socialApp = SocialChannelEntity(
            name = "Facebook",
            url = "some random url",
            iconUrl = "some icon url",
            packageName = "some package name",
            type = AppType.SOCIAL
        )
        val appList = listOf(socialApp)

        val replaceSocialApp = SocialChannelEntity(
            name = "Facebook",
            url = "REPLACED URL",
            iconUrl = "some icon url",
            packageName = "some package name",
            type = AppType.SOCIAL
        )
        val replacedAppList = listOf(replaceSocialApp)

        CoroutineScope(Dispatchers.IO).launch {
            dao.insertAll(appList)
            dao.insertAll(replacedAppList)
            val testSocialApp = dao.getSocialChannels().first()[0]
            assertEquals(testSocialApp.name, replaceSocialApp.name)
            assertEquals(testSocialApp.url, replaceSocialApp.url)
        }
    }


    @After
    fun `close db`() {
        db.close()
    }

}