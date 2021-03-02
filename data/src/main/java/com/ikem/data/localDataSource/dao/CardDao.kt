package com.ikem.data.localDataSource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ikem.data.localDataSource.entities.CardEntity

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCardInfo(cardEntity: CardEntity)

    @Query("SELECT * FROM card_table WHERE unique_id=:id LIMIT 1")
    suspend fun getCardInfo(id: Int): CardEntity?

}