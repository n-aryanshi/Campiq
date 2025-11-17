package com.example.studentapp.domain.repository
import com.example.studentapp.util.Result
interface AuthRepository {
    suspend fun login(email:String,password:String) : Result<String>
    suspend fun signup(email: String,password: String): Result<String>
}