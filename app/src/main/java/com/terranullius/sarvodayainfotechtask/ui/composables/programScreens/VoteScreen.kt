package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxWidth
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
    var age by remember {
        mutableStateOf(0)
    }

    GenericProgramScreen(
        program = program,
        modifier = modifier,
        onDone = {
            if (age>=18) "Eligible" else "Not eligible"
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            value = if (age == 0) "" else age.toString(),
            onValueChange = {
                if (it.toIntOrNull() != null){
                    age = it.toInt()
                }
            },
            keyboardType = KeyboardType.Number
        ) {}

    }}