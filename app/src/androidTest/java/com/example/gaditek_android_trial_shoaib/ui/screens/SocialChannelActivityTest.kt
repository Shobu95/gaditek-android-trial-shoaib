package com.example.gaditek_android_trial_shoaib.ui.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SocialChannelActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(SocialChannelActivity::class.java)

    @Test
    fun `1-should-have-Tab-with-text-Channels`() {
        composeTestRule
            .onNodeWithText("Channels")
            .assertIsDisplayed()
    }

    @Test
    fun `2-should-have-Tab-with-text-Socials`() {
        composeTestRule
            .onNodeWithText("Socials")
            .assertIsDisplayed()
    }

    @Test
    fun `3-should-have-Channels-list-with-Netflix-item`() {
        composeTestRule
            .onNodeWithText("Channels")
            .performClick()

        composeTestRule
            .onNodeWithText("Netflix")
            .assertIsDisplayed()

    }

    @Test
    fun `4-should-have-Socials-list-with-Facebook-item`() {
        composeTestRule
            .onNodeWithText("Socials")
            .performClick()

        composeTestRule
            .onNodeWithText("Facebook")
            .assertIsDisplayed()

    }

    /**
     * Before running this test, disable phone Internet
     */
    @Test
    fun `5-should-open-error-view-when-service-fails`() {
        composeTestRule
            .onNodeWithContentDescription("Error Image")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Something went wrong!")
            .assertIsDisplayed()
    }

}