package com.terranullius.sarvodayainfotechtask.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.terranullius.sarvodayainfotechtask.data.User
import com.terranullius.sarvodayainfotechtask.ui.MainViewModel
import com.terranullius.sarvodayainfotechtask.ui.composables.programScreens.*
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.buttonHeight
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.textFieldsSpace
import com.terranullius.sarvodayainfotechtask.util.Program
import com.terranullius.sarvodayainfotechtask.util.Resource
import com.terranullius.sarvodayainfotechtask.util.Screen
import com.terranullius.sarvodayainfotechtask.util.programList
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
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

@ExperimentalMaterialApi
@Composable
fun MainScreenSuccessContent(
    modifier: Modifier = Modifier,
    user: User,
    navController: NavHostController,
    viewModel: MainViewModel? = null
) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )

    var selectedProgram by remember {
        mutableStateOf(programList[0])
    }

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = 1.dp,
        sheetElevation = 3.dp,
        sheetShape = RoundedCornerShape(16.dp),
        sheetContent = {
            BottomSheetContent(selectedProgram = selectedProgram)
        }) {

        val coroutineScope = rememberCoroutineScope()

        Column(modifier = modifier.padding(it)) {

            Spacer(modifier = Modifier.height(18.dp))

            ProfileComposable(
                name = user.name,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                //TODO UPDATE PROFILE
                navigateRegister(
                    navController = navController
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            LazyColumn(Modifier.fillMaxSize()) {

                itemsIndexed(
                    programList
                ) { index, item ->

                    ProgramItem(name = item.screen.route, onClick = {
                        //TODO
                        selectedProgram = item
                        coroutineScope.launch {
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        }
                    })
                }
            }
        }
    }
}

@Composable
fun BottomSheetContent(selectedProgram: Program) {

    val bottomSheetPadding = 8.dp

    when (selectedProgram.screen) {
        Screen.Sum -> SumProgramScreen(Modifier.padding(bottomSheetPadding), selectedProgram)
        Screen.Product -> ProductScreen(Modifier.padding(bottomSheetPadding), selectedProgram)
        Screen.Circle -> CircleScreen(Modifier.padding(bottomSheetPadding), selectedProgram)
        Screen.EvenOdd -> EvenOddScreen(Modifier.padding(bottomSheetPadding), selectedProgram)
        Screen.Factorial -> FactorialScreen(Modifier.padding(bottomSheetPadding), selectedProgram)
        Screen.Grade -> GradeScreen(Modifier.padding(bottomSheetPadding), selectedProgram)
        Screen.Maximum -> MaxScreen(Modifier.padding(bottomSheetPadding), selectedProgram)
        Screen.Minimum -> Mincreen(Modifier.padding(bottomSheetPadding), selectedProgram)
        Screen.Prime -> PrimeScreen(Modifier.padding(bottomSheetPadding), selectedProgram)
        Screen.Vote -> VoteScreen(Modifier.padding(bottomSheetPadding), selectedProgram)
        else -> {
        }
    }
}


@Composable
fun ProgramItem(
    modifier: Modifier = Modifier,
    name: String,
    onClick: (String) -> Unit
) {
    Column(modifier = modifier) {

        Button(
            modifier =
            Modifier
                .height(buttonHeight)
                .fillMaxWidth(),
            onClick = {
                onClick(name)
            }) {
            Text(text = name)
        }
        Spacer(modifier = Modifier.height(textFieldsSpace))
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

private fun navigateRegister(
    navController: NavHostController
){
    navController.navigate(Screen.Register.route){
        launchSingleTop = true
    }
}
