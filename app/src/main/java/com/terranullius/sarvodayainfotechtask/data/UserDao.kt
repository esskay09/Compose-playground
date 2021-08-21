package com.terranullius.sarvodayainfotechtask.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpdateUser(user: User)


    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun searchByEmail(email: String): List<User>

    @Query("SELECT * FROM users WHERE number= :number")
    suspend fun searchByNumber(number: String): List<User>


}