package com.example.class_management_system.domain.usecase

import com.example.class_management_system.domain.repository.AuthRepository
import com.example.class_management_system.util.Result

class LoginUseCase(private  val authRepository: AuthRepository) {
    suspend operator  fun invoke(email: String,password:String): Result<String> {
        if (!email.contains("@")) {
            return Result.Failure("Invalid email format. '@' missing.")
        }
        return authRepository.login(email,password)
    }
}