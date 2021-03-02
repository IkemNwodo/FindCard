package com.ikem.data.remoteDataSource.responses

data class CardInfoResponse(
    val bank: Bank?,
    val brand: String? = "",
    val country: Country?,
    val type: String? = ""
)

data class Bank(
    val name: String? = ""
)

data class Country(
    val name: String? = ""
)
