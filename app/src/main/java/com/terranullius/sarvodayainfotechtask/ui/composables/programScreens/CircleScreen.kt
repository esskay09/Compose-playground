package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
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
    var radiusString by remember {
        mutableStateOf("")
    }

    var radius by remember(radiusString) {
        mutableStateOf(radiusString.toFloatOrNull() ?: 0f)
    }

    GenericProgramScreen(
        program = program
        ,
        modifier = modifier,
        onDone = {
            val area = Math.PI.times(radius.pow(2))
            val circum = Math.PI.times(2).times(radius)

            "A: ${"%.2f".format(area)}  C: ${"%.2f".format(circum)}"
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Radius")
            },
            value = radiusString,
            onValueChange = {
                radiusString = it
            },
            keyboardType = KeyboardType.Number
        ) {}


    }}
