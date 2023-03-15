package com.example.data.repository.dataSource

import com.example.domain.model.ShiftList
import retrofit2.Response

interface ShiftRemoteDataSource {
    suspend fun getAvailableShifts(query:String, currentDate: String, type: String): Response<ShiftList>
}
