package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
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
    var numString by remember {
        mutableStateOf("")
    }

    var num by remember(numString) {
        mutableStateOf(numString.toIntOrNull() ?: 0)
    }

    GenericProgramScreen(
        program = program,
        modifier = modifier,
        onDone = {
            Factorial(num).toString()
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Number")
            },
            value = numString,
            onValueChange = {
              numString = it
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
