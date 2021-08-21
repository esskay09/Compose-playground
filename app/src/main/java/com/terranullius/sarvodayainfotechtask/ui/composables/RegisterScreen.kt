package com.terranullius.sarvodayainfotechtask.ui.composables

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.terranullius.sarvodayainfotechtask.data.User
import com.terranullius.sarvodayainfotechtask.ui.MainViewModel
import com.terranullius.sarvodayainfotechtask.ui.composables.components.EditTextField
import com.terranullius.sarvodayainfotechtask.ui.composables.components.TaskButton
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.SarvodayaInfotechTaskTheme
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.buttonHeight
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.textFieldsSpace
import com.terranullius.sarvodayainfotechtask.util.Resource
import com.terranullius.sarvodayainfotechtask.util.Screen
import com.terranullius.sarvodayainfotechtask.util.showToast

@androidx.compose.runtime.Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MainViewModel?
) {
    var user by remember {
        mutableStateOf<User?>(null)
    }

    var userWrapper = viewModel?.currentUser?.collectAsState()

    user = when (userWrapper?.value) {

        is Resource.Success -> (userWrapper.value as Resource.Success).data
        else -> null
    }

    Column(modifier) {

        val context = LocalContext.current

        var isContinuable = remember {
            mutableStateOf(false)
        }

        var name by remember {
            mutableStateOf(user?.name ?: "")
        }

        var email by remember {
            mutableStateOf(user?.email ?: "")
        }

        var phoneNumber by remember {
            mutableStateOf(user?.number ?: "")
        }

        var gender by remember {
            mutableStateOf(user?.gender ?: "")
        }

        var password by remember {
            mutableStateOf("")
        }

        var confirmPassword by remember {
            mutableStateOf("")
        }

        Box(
            modifier = Modifier.weight(0.15f, true),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (user == null) "Register" else "Update",
                style = MaterialTheme.typography.h4
            )
        }

        Column(Modifier.weight(0.85f)) {

            RegisterItem(
                label = "Name",
                initialText = name,
                leadingIcon = Icons.Default.Person
            ) {
                name = it
            }
            RegisterItem(
                label = "10 digit Phone Number",
                initialText = phoneNumber,
                leadingIcon = Icons.Default.Phone
            ) {
                phoneNumber = it
            }
            RegisterItem(
                label = "Email",
                initialText = email,
                leadingIcon = Icons.Default.Email
            ) {
                email = it
            }
            RegisterItem(
                label = "Password",
                initialText = password,
                leadingIcon = Icons.Default.Password,
                keyboardType = KeyboardType.Password
            ) {
                password = it
            }

            RegisterItem(
                label = "Confirm Password",
                initialText = confirmPassword,
                leadingIcon = Icons.Default.Password
            ) {
                confirmPassword = it
            }


            Spacer(modifier = Modifier.height(50.dp))
            TaskButton(
                modifier = Modifier
                    .height(buttonHeight)
                    .fillMaxWidth(),
                isContinuable = isContinuable,
                onClick = {
                    user?.let {
                        register(
                            it.id,
                            name,
                            email,
                            phoneNumber,
                            password,
                            confirmPassword,
                            context,
                            viewModel = viewModel!!,
                            navController
                        )
                    } ?: register(
                        null,
                        name,
                        email,
                        phoneNumber,
                        password,
                        confirmPassword,
                        context,
                        viewModel = viewModel!!,
                        navController
                    )

                }) {
                Text(text = if (user == null) "REGISTER" else "UPDATE")
            }

            Spacer(modifier = Modifier.height(6.dp))

            if (user != null) TaskButton(
                modifier = Modifier
                    .height(buttonHeight)
                    .fillMaxWidth(),
                isContinuable = isContinuable,
                onClick = {
                    logout(navController)
                }) {
                Text(text = "LOGOUT")
            }

        }

    }
}

fun logout(navController: NavHostController) {
    navController.navigate(Screen.Login.route) {
        launchSingleTop = true
        popUpTo(Screen.Register.route) {
            inclusive = true
        }
    }
}

fun register(
    id: Int? = null,
    name: String,
    email: String,
    phoneNumber: String,
    password: String,
    confirmPassword: String,
    context: Context,
    viewModel: MainViewModel,
    navController: NavHostController
) {
    if (validateFields(
            name = name,
            email = email,
            phoneNumber = phoneNumber,
            password = password,
            confirmPassword = confirmPassword,
            context = context
        )
    ) {
        viewModel.registerOrUpdate(
            id = id,
            name = name,
            email = email,
            phoneNumber = phoneNumber,
            password = password,
        )
        navigateMainScreen(navController)
    }
}

private fun navigateMainScreen(navController: NavHostController) {
    navController.navigate(Screen.MainScreen.route) {
        popUpTo(Screen.Register.route) {
            this.inclusive = true
        }
    }
}

private fun validateFields(
    name: String,
    email: String,
    phoneNumber: String,
    password: String,
    confirmPassword: String,
    context: Context,
): Boolean {
    return when {
        isAnyArgEmpty(name, email, password, confirmPassword, phoneNumber) -> {
            context.showToast("Please enter all the fields")
            false
        }
        password != confirmPassword -> {
            context.showToast("Passwords do not match")
            false
        }
        else -> true
    }
}

fun isAnyArgEmpty(vararg arg: String): Boolean {
    arg.forEach {
        if (it.isBlank()) {
            return true
        }
    }
    return false
}

@Composable
fun RegisterItem(
    modifier: Modifier = Modifier.fillMaxWidth(),
    initialText: String = "",
    leadingIcon : ImageVector,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isError: MutableState<Boolean> = mutableStateOf(false),
    onDone: () -> Unit = {},
    onValueChange: (String) -> Unit = {}
) {

    var textFieldValue by remember {
        mutableStateOf(initialText)
    }

    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(textFieldsSpace))
        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                   Icon(imageVector = leadingIcon, contentDescription = "icon", tint = MaterialTheme.colors.onBackground)
            },
            value = textFieldValue,
            keyboardType = keyboardType,
            onValueChange = { newValue ->
                textFieldValue = newValue
                onValueChange(newValue)
            },
            label = {
                Text(text = label)
            }
        ) {
            onDone()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RegisterPrev() {
    SarvodayaInfotechTaskTheme() {
        RegisterScreen(
            Modifier.fillMaxSize(),
            navController = rememberNavController(),
            viewModel = null
        )
    }
}