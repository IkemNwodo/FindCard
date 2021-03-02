package com.ikem.data.di

import com.ikem.data.coroutines.DefaultDispatcherProvider
import com.ikem.data.coroutines.DispatcherProvider
import com.ikem.data.repositories.CardRepositoryImpl
import com.ikem.domain.repositories.CardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideCardInfoRepository(cardRepositoryImpl: CardRepositoryImpl): CardRepository

    @Singleton
    @Binds
    abstract fun provideDispatcherProvider(defaultDispatcherProvider: DefaultDispatcherProvider): DispatcherProvider

}