package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.terranullius.sarvodayainfotechtask.ui.composables.components.EditTextField
import com.terranullius.sarvodayainfotechtask.util.Program

@Composable
fun EvenOddScreen(
    modifier: Modifier = Modifier,
    program: Program
) {
    var num by remember {
        mutableStateOf(0)
    }

    GenericProgramScreen(
        program = program
        ,
        modifier = modifier,
        onDone = {
            if (num%2==0) "Even" else "Odd"
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            value = if (num == 0) "" else num.toString(),
            onValueChange = {
                if (it.toFloatOrNull() != null){
                    num = it.toInt()
                }
            },
            keyboardType = KeyboardType.Number
        ) {}


    }}