package com.ikem.data.localDataSource

import com.ikem.data.localDataSource.dao.CardDao
import com.ikem.data.localDataSource.entities.CardEntity
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(cardDao: CardDao) : LocalDataSource  {
    override suspend fun saveCard(cardEntity: CardEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getCard(cardNumber: Int): CardEntity? {
        TODO("Not yet implemented")
    }
}