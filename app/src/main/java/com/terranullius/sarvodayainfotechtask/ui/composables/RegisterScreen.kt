package com.terranullius.sarvodayainfotechtask.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.terranullius.sarvodayainfotechtask.data.User
import com.terranullius.sarvodayainfotechtask.ui.composables.components.EditTextField
import com.terranullius.sarvodayainfotechtask.ui.composables.components.TaskButton
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.SarvodayaInfotechTaskTheme
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.buttonHeight
import com.terranullius.sarvodayainfotechtask.ui.composables.theme.textFieldsSpace

@androidx.compose.runtime.Composable
fun RegisterScreen(modifier: Modifier = Modifier, user: User? = null, navController: NavHostController?= null) {
    Column(modifier) {

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
            Text(text = "Register", style = MaterialTheme.typography.h4)
        }

        Column(Modifier.weight(0.85f)) {

            RegisterItem(
                label = "Name",
                initialText = name,
            ) {
                name = it
            }
            RegisterItem(
                label = "10 digit Phone Number",
                initialText = phoneNumber,
            ) {
                phoneNumber = it
            }
            RegisterItem(
                label = "Email",
                initialText = email,
            ) {
                email = it
            }
            RegisterItem(
                label = "Password",
                initialText = password,
                keyboardType = KeyboardType.Password
            ) {
                password = it
            }

            RegisterItem(
                label = "Confirm Password",
                initialText = confirmPassword,
            ) {
                confirmPassword = it
            }


            Spacer(modifier = Modifier.height(50.dp))
            TaskButton(
                modifier = Modifier.height(buttonHeight).fillMaxWidth(),
                isContinuable = isContinuable,
                onClick = {
                //TODO
            }) {
                Text(text = "REGISTER")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPrev() {
    SarvodayaInfotechTaskTheme() {
        RegisterScreen(Modifier.fillMaxSize())
    }
}

@Composable
fun RegisterItem(
    modifier: Modifier = Modifier.fillMaxWidth(),
    initialText: String = "",
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