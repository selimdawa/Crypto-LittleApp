package com.littleapp.crypto.ui.detail

import com.littleapp.crypto.base.BaseRepository
import com.littleapp.crypto.network.CryptoApi
import javax.inject.Inject

class DetailRepository @Inject constructor(private val apiFactory: CryptoApi) : BaseRepository() {

    suspend fun getDetail(apiKey: String, symbol: String) =
        safeApiRequest { apiFactory.getDetail(apiKey, symbol) }
}