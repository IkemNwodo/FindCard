package com.ikem.data.localDataSource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ikem.data.remoteDataSource.responses.Bank
import com.ikem.data.remoteDataSource.responses.Country
import com.ikem.data.utils.Constants.CARD_INFO_TABLE_NAME

@Entity(tableName = CARD_INFO_TABLE_NAME)
data class CardEntity(

    @PrimaryKey
    @ColumnInfo(name = "unique_id")
    val id: Int? = 0,
    val bank: String?,
    val brand: String? = "",
    val country: String? = "",
    val type: String? = "",
    val prepaid: String? = "",
    val length: String? = "",
    val scheme: String? = ""
)
