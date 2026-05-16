package com.littleapp.crypto.ui.home

import com.littleapp.crypto.base.BaseRepository
import com.littleapp.crypto.network.ApiFactory
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiFactory: ApiFactory) : BaseRepository() {

    suspend fun getData(apiKey: String, limit: String) =
        safeApiRequest { apiFactory.getData(apiKey, limit) }
}