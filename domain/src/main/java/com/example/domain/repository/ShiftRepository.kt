package com.example.domain.repository

import com.example.domain.model.ShiftList
import com.example.domain.util.Result

interface ShiftRepository {
    suspend fun getAvailableShifts(
        query: String,
        currentTime: String,
        type: String
    ): Result<ShiftList>
}
