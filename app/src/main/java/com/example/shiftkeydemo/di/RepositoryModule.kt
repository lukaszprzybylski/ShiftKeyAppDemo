package com.example.shiftkeydemo.di

import com.example.data.repository.ShiftRepositoryImpl
import com.example.data.repository.dataSource.ShiftRemoteDataSource
import com.example.domain.repository.ShiftRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideShiftRepository(shiftRemoteDataSource: ShiftRemoteDataSource) : ShiftRepository =
        ShiftRepositoryImpl(shiftRemoteDataSource)
}
