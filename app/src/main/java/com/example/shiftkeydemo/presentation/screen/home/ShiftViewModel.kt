package com.example.shiftkeydemo.presentation.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ShiftList
import com.example.domain.model.ShiftX
import com.example.domain.useCase.GetAvailableShiftsUseCase
import com.example.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ShiftViewModel @Inject constructor(
    private val getAvailableShiftsUseCase: GetAvailableShiftsUseCase
) : ViewModel() {
    private var _shiftState = mutableStateOf<Result<ShiftList>>(Result.Loading())
    val shiftState: State<Result<ShiftList>> = _shiftState

     fun getAvailableShifts(text: String) {
        viewModelScope.launch {
          _shiftState.value =  getAvailableShiftsUseCase(text, getCurrentDate(), TYPE)
        }
    }

    var shiftx by mutableStateOf<ShiftX?>(null)
        private set

    fun addShift(newShift: ShiftX) {
        shiftx = newShift
    }
    private fun getCurrentDate() : String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return  formatter.format(time)
    }

    companion object {
        const val TYPE = "week"
    }
}
