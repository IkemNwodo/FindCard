package com.ikem.data.remoteDataSource

import com.ikem.data.remoteDataSource.responses.CardInfoResponse
import retrofit2.Response

class RemoteDataSourceImp : RemoteDataSource{
    override suspend fun getCardInfo(cardNumber: Int): Response<CardInfoResponse> {
        TODO("Not yet implemented")
    }
}