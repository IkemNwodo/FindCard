package com.ikem.data.remoteDataSource

import com.ikem.data.remoteDataSource.responses.CardInfoResponse
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getCardInfo(cardNumber: Int): Response<CardInfoResponse>
}