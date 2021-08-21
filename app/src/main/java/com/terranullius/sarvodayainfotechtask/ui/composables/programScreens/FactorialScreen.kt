package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.terranullius.sarvodayainfotechtask.ui.composables.components.EditTextField
import com.terranullius.sarvodayainfotechtask.util.Program

@Composable
fun FactorialScreen(
    modifier: Modifier = Modifier,
    program: Program
) {
    var number by remember {
        mutableStateOf(0)
    }

    GenericProgramScreen(
        program = program,
        modifier = modifier,
        onDone = {
            Factorial(number).toString()
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            value = if (number.equals(0)) "" else number.toString(),
            onValueChange = {
                if (it.toIntOrNull() != null){
                    number = it.toInt()
                }
            },
            keyboardType = KeyboardType.Number
        ) {}
    }}

private fun Factorial(num: Int): Long {
    var x = num
    var result = 1L
    while (x>1){
        result *= x
        x--
    }
    return result
}
