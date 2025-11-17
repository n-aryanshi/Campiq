package com.example.teacherapp.domain.usecase

import com.example.teacherapp.domain.repository.AuthRepository
import com.example.teacherapp.util.ResultState


//Validate input - checks user data is correct or not
//Call repository to perform signup (API / DB)
//Map repository result to ResultState (Success / Error / Loading)
//Be testable and reusable

class SignUpUseCase(private  val authRepository: AuthRepository){

    //step 1 - make repository
    //since repository gives the data/result and usecase maps it to resultstate

    //*operator fun invoke*
    // means you can call the class object like a function
    suspend operator fun invoke(email: String, password: String): ResultState<String>{

        if(email.isBlank() || password.isBlank()){
            return ResultState.Error("Email or password cannot be empty")
        }

        if(password.length<8){
            return ResultState.Error("Password must be at least 6 characters")
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ResultState.Error("Invalid email")
        }

        return authRepository.signup(email,password)

    }

}