package com.terranullius.sarvodayainfotechtask.util

import com.terranullius.bhoomicabs.util.Event

sealed class Resource<out R> {

    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val msg: Event<String>) : Resource<Nothing>()
    object Loading : Resource<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$msg]"
            Loading -> "Loading"
        }
    }
}