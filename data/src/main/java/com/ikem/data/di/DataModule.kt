package com.ikem.data.di

import com.ikem.data.localDataSource.LocalDataSource
import com.ikem.data.localDataSource.LocalDataSourceImp
import com.ikem.data.localDataSource.dao.CardDao
import com.ikem.data.remoteDataSource.RemoteDataSource
import com.ikem.data.remoteDataSource.RemoteDataSourceImp
import com.ikem.data.remoteDataSource.api.CardInfoService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun provideLocalDataSource(localDataSourceImp: LocalDataSourceImp): LocalDataSource

    @Singleton
    @Binds
    abstract fun provideRemoteDataSource(remoteDataSourceImp: RemoteDataSourceImp): RemoteDataSource
}