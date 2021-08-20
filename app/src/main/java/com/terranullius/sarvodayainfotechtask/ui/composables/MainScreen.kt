package com.terranullius.sarvodayainfotechtask.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.terranullius.sarvodayainfotechtask.data.User
import com.terranullius.sarvodayainfotechtask.ui.MainViewModel
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.buttonHeight
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.textFieldsSpace
import com.terranullius.sarvodayainfotechtask.util.Resource
import com.terranullius.sarvodayainfotechtask.util.programList

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
    Column(modifier = modifier) {

        val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
        )

        var selectedProgram by remember {
            mutableStateOf(programList[0].name)
        }
        
        BottomSheetScaffold(sheetContent = {
            when(selectedProgram){

            }
        }) {

        }

        Spacer(modifier = Modifier.height(18.dp))

        ProfileComposable(
            name = user.name,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            //TODO UPDATE PROFILE
        }

        LazyColumn(Modifier.fillMaxSize()) {

            itemsIndexed(
                programList
            ){ index, item ->

                ProgramItem(name = item.name, onClick = {
                    //TODO
                })
            }
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
