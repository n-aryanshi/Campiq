package com.example.teacherapp.domain.repository

import com.example.teacherapp.util.ResultState

/**
 * Repository
 * handles data operations
 * decides that where data comes from.
 *
 * why it is interface?
 *
 * Why suspend fun?
 * suspend fun is used because data operations can be slow (network or DB).
 * suspend allows calling it asynchronously in a coroutine.
 * It doesn’t block the main thread.
**/
interface AuthRepository {
    suspend fun login(email: String, password: String): ResultState<String>
    suspend fun signup(email: String, password: String): ResultState<String>
}

//now its implementation is made in data layer
//data layer actual knows the sources of data(api/db)
//domain should know just the info that there is some data coming for login/signup - how is not known
//repository in domain - we declare the function needed, but for data logic repsitoryimpl in data is made