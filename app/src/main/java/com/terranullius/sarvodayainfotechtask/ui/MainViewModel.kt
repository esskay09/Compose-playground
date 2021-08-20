package com.terranullius.sarvodayainfotechtask.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import androidx.room.RoomDatabase
import com.terranullius.sarvodayainfotechtask.data.AppDatabase
import com.terranullius.sarvodayainfotechtask.data.User
import com.terranullius.sarvodayainfotechtask.util.Constants.DATABASE_NAME
import com.terranullius.sarvodayainfotechtask.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val _currentUser = MutableStateFlow<Resource<User>>(Resource.Loading)
    val currentUser: StateFlow<Resource<User>>
        get() = _currentUser

    private val userDao =
        Room.databaseBuilder(app, AppDatabase::class.java, DATABASE_NAME).build().getUserDao()

    fun insertUpdateUser(user: User) {
        viewModelScope.launch {
            withContext(IO) {
                userDao.insertUpdateUser(user)
            }
        }
    }

    private suspend fun getUserByNumberOrEmail(emailOrPhone: String): User? {
        return withContext(IO) {
            val emailResult = userDao.searchByEmail(emailOrPhone)
            val numberResult = userDao.searchByNumber(emailOrPhone)

            return@withContext if (emailResult.isEmpty() && numberResult.isEmpty()) {
                null
            } else {
                if (emailResult.isNotEmpty()) {
                    emailResult.first()
                } else {
                    numberResult.first()
                }
            }
        }
    }

    fun login(
        emailOrPhone: String,
        password: String
    ) {
        viewModelScope.launch {
            _currentUser.value = Resource.Loading

            val user = getUserByNumberOrEmail(emailOrPhone)

            if (user == null) {
                _currentUser.value = Resource.Error("No user found")
            } else {
                if (user.password == password) {
                    _currentUser.value = Resource.Success(user)
                } else {
                    _currentUser.value = Resource.Error("Invalid Password")
                }
            }
        }
    }
}

