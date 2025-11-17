package com.example.teacherapp.util

//making this a  sealed class to know all the classes inherited this(at compile time only)
sealed class ResultState<out T> { //making return type generic
    //idle and loading are states that's why these are data object
    data object Idle: ResultState<Nothing>() //nothing will return
    data object Loading: ResultState<Nothing>() //nothing will return

    //success and error carry data that's why these are data classes
    data class Success<T>(val data:T) : ResultState<T>() //return generic type data (example any data from api or database)
    data class Error(val msg:String) : ResultState<Nothing>() //returns nothing but shows a msg fixed for error

}