package com.example.studentapp.domain.usecase

import com.example.studentapp.domain.repository.AuthRepository
import com.example.studentapp.util.Result
class SignUpUseCase(private  val authRepository: AuthRepository){
    suspend operator  fun invoke(email:String,password:String): Result<String> {
        if (!email.contains("@")) {
            return Result.Failure("Invalid email format. '@' missing.")
        }
        return  authRepository.signup(email,password)
    }
}