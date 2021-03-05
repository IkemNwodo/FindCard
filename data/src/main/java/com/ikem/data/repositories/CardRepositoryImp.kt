package com.ikem.data.repositories

import com.ikem.data.coroutines.DispatcherProvider
import com.ikem.data.localDataSource.LocalDataSource
import com.ikem.data.mappers.CardMapperLocalSource
import com.ikem.data.mappers.CardMapperRemoteSource
import com.ikem.data.remoteDataSource.RemoteDataSource
import com.ikem.domain.Result
import com.ikem.domain.entities.CardInfo
import com.ikem.domain.repositories.CardRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val dispatchers: DispatcherProvider
) : CardRepository {
    override suspend fun getCardInfo(cardNumber: Int): Result<CardInfo> = withContext(dispatchers.io()) {

        return@withContext when (val local = localDataSource.getCard(cardNumber)) {
            null -> {
                val cardResult = remoteDataSource.getCardInfo(cardNumber)
                if (cardResult.isSuccessful) {
                    val remoteData = cardResult.body()
                    if (remoteData != null) {
                        val mapper = CardMapperRemoteSource()
                        localDataSource.saveCard(mapper.mapToCardEntity(remoteData, cardNumber))
                        Result.Success(mapper.transform(remoteData))
                    } else {
                        Result.Success(null)
                    }
                } else {
                    Result.Error(Exception("Invalid data/failure"))
                }
            }
            else -> {
                val mapperLocal = CardMapperLocalSource()
                Result.Success(mapperLocal.transform(local))
            }

        }

    }
}