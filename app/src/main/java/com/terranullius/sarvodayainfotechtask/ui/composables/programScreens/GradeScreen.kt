package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.terranullius.sarvodayainfotechtask.ui.composables.components.EditTextField
import com.terranullius.sarvodayainfotechtask.util.Program

@Composable
fun GradeScreen(
    modifier: Modifier = Modifier,
    program: Program
) {
    var score by remember {
        mutableStateOf(0f)
    }

    GenericProgramScreen(
        program = program,
        modifier = modifier,
        onDone = {
            getGrade(score)
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            value = if (score.equals(0f)) "" else score.toString(),
            onValueChange = {
                if (it.toFloatOrNull() != null) {
                    score = it.toFloat()
                }
            },
            keyboardType = KeyboardType.Number
        ) {}


    }
}

fun getGrade(score: Float): String {
    return if (score <= 40f) "Fail"
    else if (score > 41f && score <= 50f) "DD"
    else if (score > 51f && score <= 60f) "CD"
    else if (score > 61f && score <= 70f) "BC"
    else if (score > 71f && score <= 80f) "BB"
    else if (score > 81f && score <= 90f) "AB"
    else if (score > 91f && score <= 1000f) "AA"
    else "Invalid Input"

}
