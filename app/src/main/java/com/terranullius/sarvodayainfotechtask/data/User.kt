package com.terranullius.sarvodayainfotechtask.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = -1,
    val name: String,
    val email: String,
    val number: String,
    val gender: String,
    val password: String
)
