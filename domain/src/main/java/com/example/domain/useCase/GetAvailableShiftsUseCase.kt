package com.example.domain.useCase

import com.example.domain.repository.ShiftRepository

class GetAvailableShiftsUseCase(private val shiftRepository: ShiftRepository) {
    suspend operator fun invoke(query: String, currentDate: String, type: String) =
        shiftRepository.getAvailableShifts(query, currentDate, type)

}
