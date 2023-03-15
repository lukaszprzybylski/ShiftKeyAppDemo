package com.example.shiftkeydemo.di

import com.example.data.api.ShiftAPI
import com.example.data.repository.dataSource.ShiftRemoteDataSource
import com.farhan.tanvir.data.repository.dataSourceImpl.ShiftRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideShiftsRemoteDataSource(shiftAPI: ShiftAPI) : ShiftRemoteDataSource =
        ShiftRemoteDataSourceImpl(shiftAPI)
}
