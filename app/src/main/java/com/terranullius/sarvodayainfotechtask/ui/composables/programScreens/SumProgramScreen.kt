package com.terranullius.sarvodayainfotechtask.ui.composables.programScreens

import android.text.TextUtils
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
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
fun SumProgramScreen(
    modifier: Modifier = Modifier,
    program: Program
) {


    var num1String by remember {
        mutableStateOf("")
    }

    var num2String by remember {
        mutableStateOf("")
    }


    var num1 by remember(num1String) {
        mutableStateOf(num1String.toFloatOrNull() ?: 0f)
    }

    var num2 by remember(num2String) {
        mutableStateOf(num2String.toFloatOrNull()  ?: 0f)
    }

    GenericProgramScreen(
        program = program,
        modifier = modifier,
        onDone = {
            num1.plus(num2).toString()
        }) {

        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            value = num1String,
            onValueChange = {
                num1String = it
            },
            keyboardType = KeyboardType.Number,
            label = {
                Text(text = "First Number")
            }
        ) {}

           EditTextField(
               modifier = Modifier.fillMaxWidth(),
               value = num2String,
               onValueChange = {
                  num2String = it
               },
               keyboardType = KeyboardType.Number,
               label = {
                   Text(text = "Second Number")
               }
        ) {}


    }
}