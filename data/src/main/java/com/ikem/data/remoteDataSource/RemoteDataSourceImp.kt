package com.ikem.data.remoteDataSource

import com.ikem.data.remoteDataSource.api.CardInfoService
import com.ikem.data.remoteDataSource.responses.CardInfoResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(val cardInfoService: CardInfoService) : RemoteDataSource{
    override suspend fun getCardInfo(cardNumber: Int): Response<CardInfoResponse> {
       return cardInfoService.getCardInfo(cardNumber)
    }
}