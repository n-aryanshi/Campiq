package com.example.class_management_system.domain.repository
import com.example.class_management_system.util.Result
interface AuthRepository {
    suspend fun login(email:String,password:String) : Result<String>
    suspend fun signup(email: String,password: String): Result<String>
}