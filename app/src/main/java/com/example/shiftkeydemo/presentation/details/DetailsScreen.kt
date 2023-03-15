package com.example.shiftkeydemo.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shiftkeydemo.R
import com.example.shiftkeydemo.presentation.components.ProfileProperty
import com.example.shiftkeydemo.presentation.screen.home.ShiftViewModel

@Composable
fun DetailsScreen(viewModel: ShiftViewModel) {

    Column {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text(text = stringResource(R.string.details_view))
            })

        Card(
            elevation = 0.dp,
            backgroundColor = MaterialTheme.colors.background
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                viewModel.shiftx?.shift_kind?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                viewModel.shiftx?.normalized_start_date_time?.let {
                    ProfileProperty(
                        label = stringResource(
                            id = R.string.start_shift
                        ), value = it
                    )
                }
                viewModel.shiftx?.normalized_end_date_time?.let {
                    ProfileProperty(
                        label = stringResource(
                            id = R.string.end_shift
                        ), value = it
                    )
                }
                viewModel.shiftx?.localized_specialty?.name?.let {
                    ProfileProperty(
                        label = stringResource(
                            id = R.string.specialty
                        ), value = it
                    )
                }
                viewModel.shiftx?.facility_type?.name?.let {
                    ProfileProperty(
                        label = stringResource(
                            id = R.string.facility_type
                        ), value = it
                    )
                }
            }
        }
    }
}
