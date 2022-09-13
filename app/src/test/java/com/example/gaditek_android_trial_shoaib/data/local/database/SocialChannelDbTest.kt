package com.example.gaditek_android_trial_shoaib.data.local.database

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gaditek_android_trial_shoaib.data.local.entity.SocialChannelEntity
import com.example.gaditek_android_trial_shoaib.domain.enums.AppType
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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
            assertEquals(testSocialApp.name, socialApp.url)
        }
    }

/*    @Test
    fun `4- conflicting strategy should replace`() {

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
        }

        val replaceSocialApp = SocialChannelEntity(
            name = "Facebook",
            url = "replaced url",
            iconUrl = "some icon url",
            packageName = "some package name",
            type = AppType.SOCIAL
        )

        val replacedAppList = listOf(replaceSocialApp)
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertAll(replacedAppList)
            val testSocialApp = dao.getSocialChannels().toList()[0] as SocialChannelEntity
            assertEquals(testSocialApp.name, socialApp.url)
        }
    }*/


    @After
    fun `close db`() {
        db.close()
    }

}