package com.terranullius.sarvodayainfotechtask.ui

import androidx.lifecycle.ViewModel
import com.terranullius.sarvodayainfotechtask.data.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?>
        get() = _currentUser

    fun setCurrentUser(user: User) {
        _currentUser.value = user
    }
}