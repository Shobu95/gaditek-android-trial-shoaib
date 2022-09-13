package com.example.gaditek_android_trial_shoaib.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gaditek_android_trial_shoaib.data.local.entity.SocialChannelEntity
import com.example.gaditek_android_trial_shoaib.domain.enums.AppType
import kotlinx.coroutines.flow.Flow

@Dao
interface SocialChannelDao {

    @Query("SELECT * FROM social_channel_table WHERE type = :type")
    fun getSocialChannels(type: AppType): Flow<List<SocialChannelEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(socialChannels: List<SocialChannelEntity>)

}