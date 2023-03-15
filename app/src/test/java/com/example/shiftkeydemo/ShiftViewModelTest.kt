package com.example.shiftkeydemo

import androidx.compose.runtime.MutableState
import com.example.domain.model.ShiftList
import com.example.domain.repository.ShiftRepository
import com.example.domain.useCase.GetAvailableShiftsUseCase
import com.example.domain.util.Result
import com.example.shiftkeydemo.presentation.screen.home.ShiftViewModel
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.whenever
import java.io.IOException


class ShiftViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()

    @Mock
    lateinit var shiftRepository: ShiftRepository

    @Mock
    lateinit var getAvailableShiftsUseCase: GetAvailableShiftsUseCase

    @Mock
    lateinit var viewModel: ShiftViewModel

    private var mockedParams = "Dallas"
    private var mockedCurrentDate = "2023-14-01"
    private var mockedPeriodType = "week"

    private val mockedShiftList: Result<ShiftList> = mockk()
    private val mockedShiftState: MutableState<Result<ShiftList>> = mockk()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        getAvailableShiftsUseCase = GetAvailableShiftsUseCase(shiftRepository)
        viewModel = ShiftViewModel(getAvailableShiftsUseCase)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getShifts_isSuccess() = runTest {
        whenever(shiftRepository.getAvailableShifts(mockedParams, mockedCurrentDate, mockedPeriodType)).thenReturn(mockedShiftList)
        viewModel.getAvailableShifts(mockedParams)
        val shiftList = getAvailableShiftsUseCase.invoke(mockedParams, mockedCurrentDate, mockedPeriodType)
        assertEquals(mockedShiftList, shiftList)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getShift_isFail() = runTest {
        whenever(shiftRepository.getAvailableShifts(mockedParams, mockedCurrentDate, mockedPeriodType)) doAnswer {
            throw IOException()
        }
        assertNotEquals(mockedShiftState , viewModel.shiftState)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getShift_isLoading() = runTest {
        whenever(shiftRepository.getAvailableShifts(mockedParams, mockedCurrentDate, mockedPeriodType)).thenReturn(mockedShiftList)
        assertNotEquals(mockedShiftState , viewModel.shiftState)
    }
}
