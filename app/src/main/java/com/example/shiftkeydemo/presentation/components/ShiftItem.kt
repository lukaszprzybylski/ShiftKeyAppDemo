package com.example.shiftkeydemo.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.domain.model.ShiftX
import com.example.shiftkeydemo.presentation.navigation.Screen
import com.example.shiftkeydemo.presentation.screen.home.ShiftViewModel

@Composable
fun ShiftItem(shift: ShiftX, navController: NavHostController, shiftViewModel: ShiftViewModel) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        elevation = 8.dp,

        ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth()
                .padding(start = 8.dp)
                .clickable {
                    shiftViewModel.addShift(newShift = shift)
                    navController.navigate(Screen.ShiftDetails.route)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.height(IntrinsicSize.Max)) {
                Text(text = shift.normalized_end_date_time, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = shift.shift_kind,
                    style = MaterialTheme.typography.body1,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = shift.skill.name, style = MaterialTheme.typography.subtitle1)
                }
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}
