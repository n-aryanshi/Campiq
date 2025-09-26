package com.example.class_management_system.data.repository

import com.example.class_management_system.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import com.example.class_management_system.util.Result
class AuthRepositoryImpl(
  private  val firebaseAuth: FirebaseAuth
):AuthRepository {
    override suspend fun login(email: String, password: String): Result<String> {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            delay(1000)
            Result.Success("Login Successful")
        } catch (e: Exception) {
            Result.Failure(e.localizedMessage ?: "Unknown error during login")
        }
    }

    override suspend fun signup(email: String, password: String): Result<String> {
        return try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            delay(1000)
            Result.Success("Signup Successful")
        } catch (e: Exception) {
            Result.Failure(e.localizedMessage ?: "Try to signup again")
        }
    }
}