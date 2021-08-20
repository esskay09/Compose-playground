package com.terranullius.sarvodayainfotechtask.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.terranullius.sarvodayainfotechtask.util.Screen

@Composable
fun Navigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController =navController,
        startDestination = Screen.Login.route,
        modifier = modifier
    ){
        composable(Screen.Login.route){
            LoginScreen(navController, Modifier.fillMaxSize())
        }
        composable(Screen.Register.route){
            RegisterScreen(Modifier.fillMaxSize(), null, navController)
        }
    }
}