package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.terranullius.sarvodayainfotechtask.ui.composables.components.EditTextField
import com.terranullius.sarvodayainfotechtask.util.Program


@Composable
fun VoteScreen(
    modifier: Modifier = Modifier,
    program: Program
) {
    var ageString by remember {
        mutableStateOf("")
    }

    var age by remember(ageString) {
        mutableStateOf(ageString.toIntOrNull() ?: 0)
    }

    GenericProgramScreen(
        program = program,
        modifier = modifier,
        onDone = {
            if (age>=18) "Eligible" else "Not eligible"
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Age")
            },
            value = ageString,
            onValueChange = {
               ageString = it
            },
            keyboardType = KeyboardType.Number
        ) {}

    }}