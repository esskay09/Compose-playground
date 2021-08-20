package com.terranullius.sarvodayainfotechtask.ui.composables.components


import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
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
            backgroundColor = if (!isContinuable.value) primaryDisabled else MaterialTheme.colors.primary
        ),
        onClick = onClick
    ){
        content()
    }
}