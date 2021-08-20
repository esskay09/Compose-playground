package com.terranullius.sarvodayainfotechtask.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.terranullius.sarvodayainfotechtask.ui.MainViewModel
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.SarvodayaInfotechTaskTheme
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.mainPadding

@Composable
fun MyApp(modifier: Modifier = Modifier, viewModel: MainViewModel) {

    SarvodayaInfotechTaskTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Navigation(Modifier.fillMaxSize().padding(mainPadding), viewModel)
        }
    }
}