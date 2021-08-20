package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.terranullius.sarvodayainfotechtask.ui.composables.components.EditTextField
import com.terranullius.sarvodayainfotechtask.util.Program

@Composable
fun Mincreen(
    modifier: Modifier = Modifier,
    program: Program
) {
    var num1 by remember {
        mutableStateOf(0f)
    }

    var num2 by remember {
        mutableStateOf(0f)
    }

    GenericProgramScreen(
        program = program
        ,
        modifier = modifier,
        onDone = {
            minOf(num1, num2).toString()
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            value = if (num1.equals(0f)) "" else num1.toString(),
            onValueChange = {
                if (it.toFloatOrNull() != null){
                    num1 = it.toFloat()
                }
            },
            keyboardType = KeyboardType.Number
        ) {}

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            value = if (num2.equals(0f)) "" else num2.toString(),
            onValueChange = {
                if (it.toFloatOrNull() != null){
                    num2 = it.toFloat()
                }
            },
            keyboardType = KeyboardType.Number
        ) {}


    }}