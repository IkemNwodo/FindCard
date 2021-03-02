package com.ikem.data.localDataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ikem.data.localDataSource.dao.CardDao
import com.ikem.data.localDataSource.entities.CardEntity
import com.ikem.data.typeConverter.Converters

@Database(entities = [CardEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CardInfoDatabase : RoomDatabase(){

    abstract val cardInfoDao: CardDao
}