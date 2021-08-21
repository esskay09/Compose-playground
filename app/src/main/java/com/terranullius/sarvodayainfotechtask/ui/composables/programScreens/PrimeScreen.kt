package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
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
            if (isPrime(num)) "Prime" else "Composite"
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Number")
            },
            value = numString,
            onValueChange = {
               numString
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
