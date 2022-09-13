package com.example.gaditek_android_trial_shoaib.data.repository

import com.example.gaditek_android_trial_shoaib.data.local.database.SocialChannelDao
import com.example.gaditek_android_trial_shoaib.data.local.entity.asDomainModel
import com.example.gaditek_android_trial_shoaib.data.remote.client.SocialChannelService
import com.example.gaditek_android_trial_shoaib.data.remote.dto.channelsAsDatabaseModel
import com.example.gaditek_android_trial_shoaib.data.remote.dto.socialsAsDatabaseModel
import com.example.gaditek_android_trial_shoaib.domain.model.SocialChannelModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SocialChannelRepositoryImpl
@Inject constructor(
    private val dao: SocialChannelDao,
    private val service: SocialChannelService
) : SocialChannelRepository {

    override fun getSocialChannels(): Flow<List<SocialChannelModel>> {
        return dao.getSocialChannels().map {
            it.asDomainModel()
        }
    }

    override suspend fun refreshSocialChannels() {
        withContext(Dispatchers.IO) {
            val socialChannelList = service.getSocialChannels()
            dao.insertAll(socialChannelList.body.channelsAsDatabaseModel())
            dao.insertAll(socialChannelList.body.socialsAsDatabaseModel())
        }
    }
}