package com.terranullius.sarvodayainfotechtask.ui.composables.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.blue200
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.blue500
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.lightBlueHeadline
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.orange500

@Composable
fun ProgramButton(
modifier: Modifier = Modifier,
onClick: ()-> Unit = {},
content: @Composable () -> Unit) {

    Button(
        onClick = onClick ,
        modifier = modifier
      /*  colors = ButtonDefaults.buttonColors(
            backgroundColor = blue500,
            contentColor = MaterialTheme.colors.onPrimary
        )*/

    ) {
        content()
    }
}