package com.ikem.data.localDataSource

import com.ikem.data.localDataSource.dao.CardDao
import com.ikem.data.localDataSource.entities.CardEntity
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(val cardDao: CardDao) : LocalDataSource  {
    override suspend fun saveCard(cardEntity: CardEntity) {
        cardDao.saveCardInfo(cardEntity)
    }

    override suspend fun getCard(cardNumber: Int): CardEntity? {
       return cardDao.getCardInfo(cardNumber)
    }
}