package com.example.data.api

import com.example.domain.model.ShiftList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ShiftAPI {
    @GET("/api/v2/available_shifts")
    suspend fun getAvailableShifts(
        @Query("address") query: String,
        @Query("start") currentDate: String,
        @Query("type") typePeriod: String
    ): Response<ShiftList>
}
