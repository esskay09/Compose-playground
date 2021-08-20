package com.terranullius.sarvodayainfotechtask.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.terranullius.sarvodayainfotechtask.data.User
import com.terranullius.sarvodayainfotechtask.ui.MainViewModel
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.SarvodayaInfotechTaskTheme
import com.terranullius.sarvodayainfotechtask.util.Resource

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MainViewModel? = null
) {
    val currentUser = viewModel!!.currentUser.collectAsState()

    when (currentUser.value) {
        is Resource.Success -> {
            MainScreenSuccessContent(
                modifier = modifier,
                user = (currentUser.value as Resource.Success).data,
                navController = navController,
                viewModel = viewModel
            )
        }
        else -> {
        }
    }

}

@Composable
fun MainScreenSuccessContent(
    modifier: Modifier = Modifier,
    user: User,
    navController: NavHostController,
    viewModel: MainViewModel? = null
) {
    Column(modifier = modifier) {

        Spacer(modifier = Modifier.height(18.dp))

        ProfileComposable(
            name = user.name,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            //TODO UPDATE PROFILE
        }

        LazyColumn(Modifier.fillMaxSize()) {

        }
    }
}

@Composable
fun ProfileComposable(
    modifier: Modifier = Modifier,
    name: String,
    onClick: () -> Unit
) {
    Column(
        modifier.clickable {
            onClick()
        }) {
        Image(
            painter = rememberVectorPainter(image = Icons.Default.Person),
            contentDescription = "profile",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        Text(text = "Welcome $name", Modifier.align(Alignment.CenterHorizontally))
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPrev() {
    SarvodayaInfotechTaskTheme() {
        MainScreen(modifier = Modifier.fillMaxSize(), navController = rememberNavController())
    }
}