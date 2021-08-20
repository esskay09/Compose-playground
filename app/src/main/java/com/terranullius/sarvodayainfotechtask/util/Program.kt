package com.terranullius.sarvodayainfotechtask.util

data class Program(
    val screen: Screen,
    val programFunction: String
) {
}

val programList = listOf(
    Program(Screen.Sum, "Find Sum"),
    Program(Screen.Product, "Find Product"),
    Program(Screen.Circle, "Circumference and Area"),
    Program(Screen.Maximum, "Find Maximum"),
    Program(Screen.Minimum, "Find Minimum"),
    Program(Screen.EvenOdd, "Even or Odd"),
    Program(Screen.Vote, "Is Eligible to vote?"),
    Program(Screen.Prime, "Is a prime?"),
    Program(Screen.Grade, "Calculate Grade"),
    Program(Screen.Factorial, "Calculate Factorial")
)

