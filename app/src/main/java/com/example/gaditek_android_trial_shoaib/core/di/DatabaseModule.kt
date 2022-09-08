package com.example.gaditek_android_trial_shoaib.core.di

import android.app.Application
import androidx.room.Room
import com.example.gaditek_android_trial_shoaib.data.local.database.SocialChannelDao
import com.example.gaditek_android_trial_shoaib.data.local.database.SocialChannelDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesSocialChannelDatabase(context: Application): SocialChannelDb {
        return Room.databaseBuilder(
            context,
            SocialChannelDb::class.java,
            SocialChannelDb.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesSocialChannelDao(database: SocialChannelDb): SocialChannelDao {
        return database.socialChannelDao
    }
}