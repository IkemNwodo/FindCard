package com.ikem.data.remoteDataSource.api

import com.ikem.data.remoteDataSource.responses.CardInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CardInfoService {
    @GET("{cardNumber}")
    suspend fun getCardInfo(@Path("cardNumber") cardNumber: Int): Response<CardInfoResponse>

}