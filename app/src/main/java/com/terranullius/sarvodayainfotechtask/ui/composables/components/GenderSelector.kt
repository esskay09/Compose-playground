package com.terranullius.sarvodayainfotechtask.ui.composables.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.terranullius.sarvodayainfotechtask.util.Gender

@Composable
fun OrientationSelector(
    modifier: Modifier = Modifier,
    gender: Gender = Gender.FEMALE,
    onClick: (Gender) -> Unit ={}
) {

    Row(modifier = modifier){
        OutlinedButton(
            onClick = { onClick(Gender.MALE) },
            shape = CutCornerShape(bottomEnd = 95f),
            modifier = Modifier
                .offset(x = 20.dp)
                .padding(vertical = 6.dp),
            colors = if (gender == Gender.MALE) ButtonDefaults.outlinedButtonColors(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary
            )
            else ButtonDefaults.outlinedButtonColors()
        ) {
            Text(text = "Male")
            Spacer(modifier = Modifier.width(18.dp))
        }
        OutlinedButton(
            onClick = { onClick(Gender.FEMALE) },
            shape = CutCornerShape(topStart = 95f),
            modifier = Modifier
                .offset(x = (-20).dp)
                .padding(vertical = 6.dp),
            colors = if (gender == Gender.FEMALE) ButtonDefaults.outlinedButtonColors(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary
            )
            else ButtonDefaults.outlinedButtonColors()
        )
        {
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Vertical")
        }
    }
}