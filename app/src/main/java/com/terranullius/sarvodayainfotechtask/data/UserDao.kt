package com.terranullius.sarvodayainfotechtask.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpdateUser(user: User)

//    @Query("SELECT * FROM users WHERE ")
}