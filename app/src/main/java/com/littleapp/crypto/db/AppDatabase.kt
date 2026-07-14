package com.littleapp.crypto.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.littleapp.crypto.db.dao.CoinDao
import com.littleapp.crypto.db.entity.CoinEntity

@Database(entities = [CoinEntity::class], version = 1, exportSchema = false)
@Suppress("unused")
abstract class AppDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
}