package com.ikem.data.mappers

import com.ikem.data.localDataSource.entities.CardEntity
import com.ikem.domain.entities.CardInfo

class CardMapperLocalSource : BaseMapper<CardEntity, CardInfo> {
    override fun transform(type: CardEntity): CardInfo = CardInfo(
        bank = type.bank ?: "",
        brand = type.brand ?: "",
        country = type.country ?: "",
        type = type.type ?: "",
        scheme = type.scheme ?: "",
        prepaid = type.prepaid ?: "",
        length = type.length ?: ""
    )
}