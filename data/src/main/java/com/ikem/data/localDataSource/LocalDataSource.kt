package com.ikem.data.localDataSource

import com.ikem.data.localDataSource.entities.CardEntity

interface LocalDataSource {
    suspend fun saveCard(cardEntity: CardEntity)
    suspend fun getCard(cardNumber: Int):CardEntity?
}