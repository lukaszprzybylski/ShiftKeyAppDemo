/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.shiftkeydemo.presentation.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun SearchTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    color: Color,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions()
) {
    Card(
        backgroundColor = MaterialTheme.colors.onSurface,
        elevation = 0.dp,
        modifier = modifier.padding(horizontal = 6.dp).fillMaxWidth()
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            trailingIcon = {
                AnimatedVisibility(
                    visible = value.text.isNotEmpty(),
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {}
            },
            placeholder = { Text(text = hint) },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            maxLines = 1,
            singleLine = true,
            modifier = modifier,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = color,
                focusedIndicatorColor = Color.DarkGray,
                unfocusedIndicatorColor = Color.DarkGray,
                disabledIndicatorColor = Color.DarkGray
            )
        )
    }
}
