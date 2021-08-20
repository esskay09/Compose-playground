package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.terranullius.sarvodayainfotechtask.ui.composables.components.EditTextField
import com.terranullius.sarvodayainfotechtask.util.Program
import kotlin.math.pow

@Composable
fun CircleScreen(
    modifier: Modifier = Modifier,
    program: Program
) {
    var radius by remember {
        mutableStateOf(0f)
    }

    GenericProgramScreen(
        program = program
        ,
        modifier = modifier,
        onDone = {
            "A: ${Math.PI.times(radius.pow(2))}  C: ${Math.PI.times(2).times(radius)}"
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            value = if (radius.equals(0f)) "" else radius.toString(),
            onValueChange = {
                if (it.toFloatOrNull() != null){
                    radius = it.toFloat()
                }
            },
            keyboardType = KeyboardType.Number
        ) {}


    }}
