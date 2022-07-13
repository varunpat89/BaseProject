package com.app.baseproject.utils.core

// A generic class that contains data and failure
sealed class Resource<out T : Any> {

    data class Success<out T : Any>(val data: T) : Resource<T>()

    class Failure(val errorMessage: String) : Resource<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Failure -> "Error[exception=$errorMessage]"
        }
    }
}