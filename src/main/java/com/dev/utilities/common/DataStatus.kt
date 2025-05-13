package com.dev.utilities.common

/*data class DataStatus<out T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null,
    val isEmpty: Boolean? = false
) {

    enum class Status {
        LOADING, SUCCESS, ERROR, EMPTY
    }

    companion object{
        fun <T> loading():DataStatus<T>{
            return DataStatus(Status.LOADING)
        }
        fun <T> success(data:T?):DataStatus<T>{
            return DataStatus(Status.SUCCESS,data)
        }
        fun <T> error(message: String?):DataStatus<T>{
            return DataStatus(Status.ERROR,message = message)
        }
        fun <T> empty(): DataStatus<T> {
            return DataStatus(Status.EMPTY)
        }
    }
}*/


sealed interface DataStatus<out T> {
    object Loading : DataStatus<Nothing>
    data class Success<T>(val data: T) : DataStatus<T>
    data class Error(val message: String) : DataStatus<Nothing>
    object Empty : DataStatus<Nothing>
}