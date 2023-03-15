package com.example.shiftkeydemo.di

import com.example.domain.repository.ShiftRepository
import com.example.domain.useCase.GetAvailableShiftsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetAvailableShiftUseCase(shiftRepository: ShiftRepository) =
        GetAvailableShiftsUseCase(shiftRepository)
}
