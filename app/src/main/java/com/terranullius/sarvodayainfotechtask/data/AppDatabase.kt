package com.terranullius.sarvodayainfotechtask.data

import androidx.room.Database

@Database(entities = [User::class], version = 1)
abstract class AppDatabase {

    abstract fun getUserDao(): UserDao

}