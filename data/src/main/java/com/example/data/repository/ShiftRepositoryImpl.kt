package com.example.data.repository

import com.example.data.repository.dataSource.ShiftRemoteDataSource
import com.example.domain.model.ShiftList
import com.example.domain.repository.ShiftRepository
import com.example.domain.util.Result
import retrofit2.Response

class ShiftRepositoryImpl(private val shiftRemoteDataSource: ShiftRemoteDataSource) :
    ShiftRepository {

    override suspend fun getAvailableShifts(query: String, currentDate: String, type: String) = responseToRequest(shiftRemoteDataSource.getAvailableShifts(query, currentDate,type))

    private fun responseToRequest(response: Response<ShiftList>): Result<ShiftList> {
        if(response.isSuccessful){
            response.body()?.let {result->
                return Result.Success(result)
            }
        }
        return Result.Error(response.message())
    }
}
