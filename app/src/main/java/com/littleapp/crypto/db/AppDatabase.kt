package com.littleapp.crypto.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.littleapp.crypto.db.dao.CoinDao
import com.littleapp.crypto.db.dao.CoinDetailDao
import com.littleapp.crypto.db.entity.CoinEntity
import com.littleapp.crypto.db.entity.CoinDetailEntity

@Database(
    entities = [CoinEntity::class, CoinDetailEntity::class], version = 1, exportSchema = false
)
@Suppress("unused")
abstract class AppDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
    abstract fun coinDetailDao(): CoinDetailDao
}