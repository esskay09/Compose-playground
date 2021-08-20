package com.terranullius.sarvodayainfotechtask.util

sealed class Screen(val route: String){
    object Login: Screen("loginScreen")
    object Register: Screen("RegisterScreen")
    object MainScreen: Screen("MainScreen")
}
