package com.farhan.tanvir.data.repository.dataSourceImpl

import com.example.data.api.ShiftAPI
import com.example.data.repository.dataSource.ShiftRemoteDataSource

class ShiftRemoteDataSourceImpl(private val shiftAPI: ShiftAPI) : ShiftRemoteDataSource {
    override suspend fun getAvailableShifts(query: String, currentDate: String, type: String) =
        shiftAPI.getAvailableShifts(query, currentDate, type)

}
