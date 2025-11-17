package com.example.teacherapp.data.repositoryImpl

import com.example.teacherapp.domain.repository.AuthRepository
import com.example.teacherapp.util.ResultState
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await

/**
* Because this repository’s responsibility is authentication, and FirebaseAuth is the tool/source for that data.
* Without it, the repository wouldn’t know how or where to log the user in.
**/

//this class implements all the functions declared in AuthRepository.
class AuthRepositoryImpl(
    private val firebaseAuth: FirebaseAuth //source
): AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): ResultState<String> {
        //TODO("Not yet implemented")
        return try{
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            delay(1000)
            ResultState.Success("Login Successful")
        }catch(e: Exception){
            ResultState.Error("Unknown Error")
        }


    }

    override suspend fun signup(
        email: String,
        password: String
    ): ResultState<String> {
//        TODO("Not yet implemented")

        return try{
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            delay(1000)
            ResultState.Success("Signup Successful")
        }catch(e: Exception){
            ResultState.Error("Unknown Error. Try Again")
        }
    }

}