package com.terranullius.sarvodayainfotechtask.ui.composables.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun EditTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit = {},
    leadingIcon: @Composable () -> Unit = {},
    isError: MutableState<Boolean> = mutableStateOf(false),
    keyboardType: KeyboardType = KeyboardType.Text,
    onDone: () -> Unit
) {
    TextField(
        modifier = modifier,
        value = value,
        label = label,
        leadingIcon = leadingIcon,
        onValueChange = onValueChange,
        isError = isError.value,
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(onNext = {
            onDone()
        })
    )
}