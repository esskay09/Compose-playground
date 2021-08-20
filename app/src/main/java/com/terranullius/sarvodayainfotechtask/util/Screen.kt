package com.terranullius.sarvodayainfotechtask.util

sealed class Screen(val route: String) {
    object Login : Screen("loginScreen")
    object Register : Screen("RegisterScreen")
    object MainScreen : Screen("MainScreen")

    object Sum : Screen("Sum")
    object Product : Screen("Product")
    object Circle : Screen("Circle")
    object Maximum : Screen("Maximum")
    object Minimum : Screen("Minimum")
    object EvenOdd : Screen("Even or Odd")
    object Vote : Screen("Vote Eligibility")
    object Prime : Screen("Prime or not")
    object Grade : Screen("Grade System")
    object Factorial : Screen("Factorial")
}
