package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.buttonHeight
import com.terranullius.sarvodayainfotechtask.util.Program

@Composable
fun GenericProgramScreen(
    program: Program,
    modifier: Modifier = Modifier,
    onDone: () -> String,
    content: @Composable () -> Unit
) {

    var result by remember {
        mutableStateOf("")
    }

    Column(modifier) {

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = program.screen.route,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h5
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = result,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h5
        )

        Spacer(modifier = Modifier.height(24.dp))

        content()

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            modifier = Modifier
                .height(buttonHeight)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary, contentColor = MaterialTheme.colors.onSecondary),
            onClick = {
                result = onDone()
            }) {
            Text(text = program.programFunction)
        }

    }
}