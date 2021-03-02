package com.ikem.domain.repositories

import com.ikem.domain.entities.CardInfo
import com.ikem.domain.Result

interface CardRepository {
    suspend fun getCardInfo(cardNumber: Int): Result<CardInfo>
}