package com.example.gaditek_android_trial_shoaib.domain.use_case

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.example.gaditek_android_trial_shoaib.domain.model.SocialChannelModel
import dagger.hilt.android.qualifiers.ApplicationContext


class SocialChannelUseCase(@ApplicationContext val context: Context) {

    operator fun invoke(socialChannel: SocialChannelModel) {

        val pm: PackageManager = context.packageManager
        val intent: Intent? = pm.getLaunchIntentForPackage(socialChannel.packageName)
        intent?.let {
            context.startActivity(intent)
            return
        }
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(socialChannel.url))
        context.startActivity(browserIntent)

    }
}