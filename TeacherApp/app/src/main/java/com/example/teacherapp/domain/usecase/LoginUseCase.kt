package com.example.teacherapp.domain.usecase

import com.example.teacherapp.domain.repository.AuthRepository
import com.example.teacherapp.util.ResultState

class LoginUseCase(private  val authRepository: AuthRepository){

    suspend operator fun invoke(email:String, password:String): ResultState<String>{

        if(email.isBlank() || password.isBlank()){
            return ResultState.Error("Email or password cannot be empty")
        }

        if(password.length<8){
            return ResultState.Error("Password must be at least 6 characters")
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ResultState.Error("Invalid email")
        }

        return authRepository.login(email,password)
    }
}