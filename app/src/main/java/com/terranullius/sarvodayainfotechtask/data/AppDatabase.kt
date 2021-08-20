package com.terranullius.sarvodayainfotechtask.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao

}