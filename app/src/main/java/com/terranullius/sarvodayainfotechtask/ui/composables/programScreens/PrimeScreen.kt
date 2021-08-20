package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.terranullius.sarvodayainfotechtask.ui.composables.components.EditTextField
import com.terranullius.sarvodayainfotechtask.util.Program


@Composable
fun PrimeScreen(
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
            if (isPrime(number)) "Prime" else "Composite"
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            value = if (number == 0) "" else number.toString(),
            onValueChange = {
                if (it.toIntOrNull() != null){
                    number = it.toInt()
                }
            },
            keyboardType = KeyboardType.Number
        ) {}

    }}

fun isPrime(number: Int): Boolean {
    for (i in 2..number/2){
        if (number%i == 0) return false
    }
    return true
}
