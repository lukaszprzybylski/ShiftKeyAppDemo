package com.example.shiftkeydemo.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shiftkeydemo.R
import com.example.shiftkeydemo.presentation.components.ShiftItem
import com.example.shiftkeydemo.ui.theme.colorSnow
import com.example.shiftkeydemo.ui.theme.white

@Composable
fun HomeScreen(navController: NavHostController, viewModel: ShiftViewModel) {

    Column {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text(text = stringResource(R.string.app_name))
            })
        Column {

            var search by rememberSaveable(stateSaver = TextFieldValue.Saver) {
                mutableStateOf(TextFieldValue())
            }

            Row(
                modifier = Modifier
                    .background(color = colorSnow)
                    .padding(10.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchTextField(
                    value = search, onValueChange = {
                        search = it
                        viewModel.getAvailableShifts(it.text)
                    }, hint = stringResource(R.string.hint_type_location),
                    color = white
                )
            }
            when (val shiftResponse = viewModel.shiftState.value) {
                is com.example.domain.util.Result.Loading -> Text(
                    text = stringResource(R.string.empty_list),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                is com.example.domain.util.Result.Success ->

                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        shiftResponse.data?.let { shiftList ->
                            items(
                                items = shiftList.data.flatMap { it.shifts },
                                itemContent = {
                                    ShiftItem(shift = it, navController = navController, shiftViewModel = viewModel)
                                }
                            )
                        }
                    }
                is com.example.domain.util.Result.Error -> Text(
                    text = stringResource(R.string.result_error),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
