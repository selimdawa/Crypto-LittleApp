package com.littleapp.crypto.network

import com.littleapp.crypto.Unit.DATA
import com.littleapp.crypto.model.detail.DetailResponse
import com.littleapp.crypto.model.home.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiFactory {

    @GET(DATA.LATEST_CRYPTO)
    suspend fun getData(
        @Header("X-CMC_PRO_API_KEY") apiKey: String,
        @Query("limit") limit: String,
    ): CryptoResponse

    @GET(DATA.INFO_CRYPTO)
    suspend fun getDetail(
        @Header("X-CMC_PRO_API_KEY") apiKey: String,
        @Query("symbol") symbol: String,
    ): DetailResponse
}