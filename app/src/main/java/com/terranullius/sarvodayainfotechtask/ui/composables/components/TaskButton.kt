package com.terranullius.sarvodayainfotechtask.ui.composables.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.terranullius.sarvodayainfotechtask.ui.composables.login
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.primaryDisabled

@Composable
fun TaskButton(
    modifier: Modifier = Modifier,
    isContinuable: MutableState<Boolean> = mutableStateOf(false),
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (!isContinuable.value) primaryDisabled else MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        ),
        onClick = onClick
    ){
        content()
    }
}