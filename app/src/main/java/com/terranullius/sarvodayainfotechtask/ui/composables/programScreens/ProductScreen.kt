package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.terranullius.sarvodayainfotechtask.ui.composables.components.EditTextField
import com.terranullius.sarvodayainfotechtask.util.Program

@Composable
fun ProductScreen(
    modifier: Modifier = Modifier,
    program: Program
) {

    var num1String by remember {
        mutableStateOf("")
    }

    var num2String by remember {
        mutableStateOf("")
    }


    var num1 by remember(num1String) {
        mutableStateOf(num1String.toFloatOrNull() ?: 0f)
    }

    var num2 by remember(num2String) {
        mutableStateOf(num2String.toFloatOrNull()  ?: 0f)
    }

    GenericProgramScreen(
        program = program,
        modifier = modifier,
        onDone = {
            num1.times(num2).toString()
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "First Number")
            },
            value = num1String,
            onValueChange = {
                num1String = it
            },
            keyboardType = KeyboardType.Number
        ) {}

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            label = {
            .    Text(text = "Second Number")
            },
            value = num2String,
            onValueChange = {
               num2String = it
            },
            keyboardType = KeyboardType.Number
        ) {}


    }
}