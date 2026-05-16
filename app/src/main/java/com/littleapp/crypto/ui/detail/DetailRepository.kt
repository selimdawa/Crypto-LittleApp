package com.littleapp.crypto.ui.detail

import com.littleapp.crypto.base.BaseRepository
import com.littleapp.crypto.network.ApiFactory
import javax.inject.Inject

class DetailRepository @Inject constructor(private val apiFactory: ApiFactory) : BaseRepository() {

    suspend fun getDetail(apiKey: String, symbol: String) =
        safeApiRequest { apiFactory.getDetail(apiKey, symbol) }
}