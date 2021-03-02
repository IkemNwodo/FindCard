package com.ikem.data.mappers

import com.ikem.data.localDataSource.entities.CardEntity
import com.ikem.data.remoteDataSource.responses.CardInfoResponse
import com.ikem.domain.entities.CardInfo

class CardMapperRemoteSource : BaseMapper<CardInfoResponse, CardInfo> {
    override fun transform(type: CardInfoResponse): CardInfo = CardInfo(
        type.bank?.name ?: "", type.brand ?: "", type.country?.name ?: "", type.type ?: ""
    )

    fun mapToCardEntity(type: CardInfoResponse): CardEntity = CardEntity(
        bank = type.bank, brand = type.brand, country = type.country
    )
}