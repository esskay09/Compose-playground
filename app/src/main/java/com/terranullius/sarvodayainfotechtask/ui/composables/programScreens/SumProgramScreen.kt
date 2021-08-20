package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.terranullius.sarvodayainfotechtask.ui.composables.components.EditTextField
import com.terranullius.sarvodayainfotechtask.util.Program

@Composable
fun SumProgramScreen(program: Program) {

    var num1 by remember {
        mutableStateOf(0f)
    }

    var num2 by remember {
        mutableStateOf(0f)
    }

    GenericProgramScreen(
        program = program,
        onDone = {
            num1.plus(num2).toString()
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            value = num1.toString(),
            onValueChange = {
                num1 = it.toFloat()
            },
            keyboardType = KeyboardType.Number
        ) {}

           EditTextField(
            modifier = Modifier.fillMaxWidth(),
            value = num2.toString(),
            onValueChange = {
                num2 = it.toFloat()
            },
            keyboardType = KeyboardType.Number
        ) {}


    }
}