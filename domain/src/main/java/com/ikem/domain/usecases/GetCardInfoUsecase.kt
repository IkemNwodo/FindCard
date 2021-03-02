package com.ikem.domain.usecases

import com.ikem.domain.repositories.CardRepository
import javax.inject.Inject

class GetCardInfoUsecase @Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke(cardNumber: Int) =
        repository.getCardInfo(cardNumber)
}