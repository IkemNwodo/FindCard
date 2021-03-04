package com.ikem.data.mappers

import com.ikem.data.localDataSource.entities.CardEntity
import com.ikem.data.remoteDataSource.responses.CardInfoResponse
import com.ikem.domain.entities.CardInfo

class CardMapperRemoteSource : BaseMapper<CardInfoResponse, CardInfo> {
    override fun transform(type: CardInfoResponse): CardInfo = CardInfo(
        bank = type.bank?.name ?: "",
        brand = type.brand ?: "",
        country = type.country?.name ?: "",
        type = type.type ?: "",
        scheme = type.scheme ?: "",
        prepaid = type.prepaid.toString(),
        length = type.number.length.toString()
    )

    fun mapToCardEntity(type: CardInfoResponse): CardEntity = CardEntity(
        bank = type.bank?.name,
        brand = type.brand,
        country = type.country?.name,
        type = type.type,
        scheme = type.scheme,
        prepaid = type.prepaid.toString(),
        length = type.number.length.toString()
    )
}