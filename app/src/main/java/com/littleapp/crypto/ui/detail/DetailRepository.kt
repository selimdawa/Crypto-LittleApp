package com.littleapp.crypto.ui.detail

import com.littleapp.crypto.base.BaseRepository
import com.littleapp.crypto.db.dao.CoinDetailDao
import com.littleapp.crypto.db.entity.CoinDetailEntity
import com.littleapp.crypto.network.CryptoApi
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val apiFactory: CryptoApi, private val coinDetailDao: CoinDetailDao
) : BaseRepository() {

    suspend fun getDetailFromApi(apiKey: String, symbol: String) =
        safeApiRequest { apiFactory.getDetail(apiKey, symbol) }

    fun getDetailFromDb(id: Int) = coinDetailDao.getCoinDetail(id)

    suspend fun saveDetailToDb(entity: CoinDetailEntity) = coinDetailDao.insertCoinDetail(entity)
}