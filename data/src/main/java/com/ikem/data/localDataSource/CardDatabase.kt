package com.ikem.data.localDataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ikem.data.localDataSource.dao.CardDao
import com.ikem.data.localDataSource.entities.CardEntity

@Database(entities = [CardEntity::class], version = 1, exportSchema = false)
abstract class CardInfoDatabase : RoomDatabase(){

    abstract val cardInfoDao: CardDao
}