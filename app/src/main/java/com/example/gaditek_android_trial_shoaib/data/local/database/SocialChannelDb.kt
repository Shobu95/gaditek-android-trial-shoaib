package com.example.gaditek_android_trial_shoaib.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gaditek_android_trial_shoaib.data.local.entity.SocialChannelEntity


@Database(
    entities = [SocialChannelEntity::class],
    version = 1
)
abstract class SocialChannelDb : RoomDatabase() {

    abstract val socialChannelDao: SocialChannelDao

    companion object {
        const val DATABASE_NAME = "social_channel_db"
    }
}