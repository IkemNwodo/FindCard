package com.ikem.data.mappers

import com.ikem.data.localDataSource.entities.CardEntity
import com.ikem.domain.entities.CardInfo

class CardMapperLocalSource : BaseMapper<CardEntity, CardInfo> {
    override fun transform(type: CardEntity): CardInfo = CardInfo(
        bank = type.bank?.name ?: "", brand = type.brand ?: "", country = type.country?.name ?: "", type = type.type ?: ""
    )
}