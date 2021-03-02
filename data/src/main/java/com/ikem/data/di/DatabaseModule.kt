package com.ikem.data.di

import android.content.Context
import androidx.room.Room
import com.ikem.data.localDataSource.CardInfoDatabase
import com.ikem.data.localDataSource.dao.CardDao
import com.ikem.data.utils.Constants.CARD_INFO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideCardInfoDatabase(@ApplicationContext appContext: Context): CardInfoDatabase {
        return Room
            .databaseBuilder(appContext, CardInfoDatabase::class.java, CARD_INFO_DATABASE)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideCardInfoDao(cardInfoDatabase: CardInfoDatabase): CardDao {
        return cardInfoDatabase.cardInfoDao
    }
}