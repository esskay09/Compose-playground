package com.terranullius.sarvodayainfotechtask.ui.composables.components

import android.text.TextUtils
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun PhoneNumberField(
    modifier: Modifier = Modifier,
    isContinuable: MutableState<Boolean> = mutableStateOf(false),
    onPhoneNumberChange: (Long) -> Unit = {},
    onDone: (Long) -> Unit = {},
) {
    val isError = remember {
        mutableStateOf(false)
    }

    var phoneNumber by remember {
        mutableStateOf(0L)
    }

    val phoneNumberError = remember {
        mutableStateOf(false)
    }


    EditTextField(
        modifier = modifier,
        value = if (phoneNumber == 0L) "" else phoneNumber.toString(),
        onValueChange = { newValue ->
            if (isValidNumber(newValue)) {
                isError.value = false
                phoneNumber = newValue.toLong()

                onPhoneNumberChange(phoneNumber)

                if (newValue.length == 10){
                    isContinuable.value = true
                }

            } else {
                isError.value = true
            }
        },
        label = {
            Text(text = "10 digit mobile number")
        },
        leadingIcon = {
            Text(text = "+91")
        },
        isError = phoneNumberError,
        keyboardType = KeyboardType.Phone,
        onDone = {
            if (!isError.value) {
                onDone(phoneNumber)
            }
        }
    )
}

private fun isValidNumber(number: String) =
    (number.length <= 10 && containsOnlyNumbers(number) && number.isNotEmpty())

fun containsOnlyNumbers(number: String): Boolean {
    return TextUtils.isDigitsOnly(number)
}