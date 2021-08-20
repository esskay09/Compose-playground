package com.terranullius.sarvodayainfotechtask.ui.composables

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.terranullius.sarvodayainfotechtask.R
import com.terranullius.sarvodayainfotechtask.ui.MainViewModel
import com.terranullius.sarvodayainfotechtask.ui.composables.components.EditTextField
import com.terranullius.sarvodayainfotechtask.ui.composables.components.TaskButton
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.lightBlueHeadline
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.textFieldsSpace
import com.terranullius.sarvodayainfotechtask.util.Resource
import com.terranullius.sarvodayainfotechtask.util.Screen
import com.terranullius.sarvodayainfotechtask.util.showToast
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {

        launch {
            viewModel.currentUser.collectLatest {
                when (it) {
                    is Resource.Error -> it.msg.getContentIfNotHandled()
                        ?.let {msg->
                            context.showToast(msg)
                        }
                    is Resource.Success -> navController.navigate(Screen.MainScreen.route)
                    else -> Unit
                }
            }
        }
    }

    var isContinuable = remember {
        mutableStateOf(false)
    }
    var phoneNumberOrEmail by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(modifier) {
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            factory = {
                LottieAnimationView(it).apply {
                    setAnimation(R.raw.login)
                    repeatCount = LottieDrawable.INFINITE
                    repeatMode = LottieDrawable.RESTART
                }
            }
        ) {
            it.playAnimation()
        }

        Column(
            Modifier
                .fillMaxSize()
        ) {

            Text(
                text = "LOGIN", style = MaterialTheme.typography.h6.copy(
                    color = lightBlueHeadline
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Enter your phone number to proceed")
            Spacer(modifier = Modifier.height(24.dp))

            EditTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Email/Phone")
                },
                value = phoneNumberOrEmail,
                onValueChange = {
                    phoneNumberOrEmail = it
                }) {

            }
            EditTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Password")
                },
                value = password,
                onValueChange = {
                    password = it
                }) {
                login(phoneNumberOrEmail, password, viewModel, context)
            }

            Spacer(modifier = Modifier.height(24.dp))
            TaskButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp),
                onClick = {
                    /*
                    * navController Null only in previews
                    * */
                    login(phoneNumberOrEmail, password, viewModel, context)
                }
            ) {
                Text(text = "LOGIN")
            }
            Spacer(modifier = Modifier.height(textFieldsSpace))
            TaskButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp),
                onClick = {
                    /*
                    * navController Null only in previews
                    * */

                    navigateRegister(navController)
                }
            ) {
                Text(text = "REGISTER")
            }
        }
    }
}

private fun validateFields(phoneNumberOrEmail: String, password: String, context: Context): Boolean {
    return if (phoneNumberOrEmail.isBlank()) {
        context.showToast("Please enter your email/number")
        false
    } else if (password.isBlank()) {
        context.showToast("Please enter your password")
        false
    } else true
}

fun navigateRegister(navController: NavHostController) {
    navController.navigate(Screen.Register.route)
}


private fun login(emailOrPhone: String, password: String, viewModel: MainViewModel, context: Context) {
    if (validateFields(emailOrPhone, password, context)) {
        viewModel.login(emailOrPhone, password)
    }
}

