package com.ikem.data.remoteDataSource.responses

data class CardInfoResponse(
    val bank: Bank?,
    val brand: String? = "",
    val country: Country?,
    val type: String? = "",
    val scheme: String? = "",
    val number: Number,
    val prepaid: Boolean
)

data class Bank(
    val name: String? = ""
)

data class Country(
    val name: String? = ""
)

data class Number(
    val length: Int
)
