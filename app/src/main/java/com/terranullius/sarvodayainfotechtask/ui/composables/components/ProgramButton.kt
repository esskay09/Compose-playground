package com.terranullius.sarvodayainfotechtask.ui.composables.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.orange500

@Composable
fun ProgramButton(
modifier: Modifier = Modifier,
onClick: ()-> Unit = {},
content: @Composable () -> Unit) {

    Button(
        onClick = onClick ,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(orange500.copy(alpha = 0.8f))) {
        content()
    }
}