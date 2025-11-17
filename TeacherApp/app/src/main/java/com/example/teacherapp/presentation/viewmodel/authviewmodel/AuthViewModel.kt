package com.example.teacherapp.presentation.viewmodel.authviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teacherapp.domain.usecase.LoginUseCase
import com.example.teacherapp.domain.usecase.SignUpUseCase
import com.example.teacherapp.util.ResultState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/*
//viewmodel
//holds UI state
//handle logic which has to be shown to ui - loading, error, success
//communicate with domain layer to get or modify data
//how data is fetched or processed -> not known

//now if business logic has to be written , we will make use cases.
//usecase - what and why?
//it is a unit of business logic
//if we write business logic separately then we can update it later without touching any part of app
//it can be reused anywhere.
//it can be tested independently easily

//summary
//If the code involves business logic or data manipulation, move it to a UseCase.
//If it involves UI flow or state management, keep it in the ViewModel.

*/
class AuthViewModel(
    private val loginUseCase: LoginUseCase,
    private val signUpUseCase: SignUpUseCase
): ViewModel() {
    
    //1.business logic to write bussiness logic
    //2. result state to show the current state of backend operations in ui

    //mutable state flow - backing property
    //state holder that emits updates about authentication,
    // ResultState.Idle means
    // It’s the initial state, when nothing has happened yet.
    private val _authState = MutableStateFlow<ResultState<String>>(ResultState.Idle)
    val authState: StateFlow<ResultState<String>> = _authState

    fun login(email: String, password: String) {
        _authState.value = ResultState.Loading
        viewModelScope.launch {
            try {
                val result = loginUseCase(email, password)
                _authState.value = result
            } catch (e: Exception) {
                _authState.value = ResultState.Error(e.message ?: "Login failed")
            }
        }
    }

    fun signup(email: String, password: String) {
        _authState.value = ResultState.Loading
        viewModelScope.launch {
            try {
                val result = signUpUseCase(email, password)
                _authState.value = result
            } catch (e: Exception) {
                _authState.value = ResultState.Error(e.message ?: "Signup failed")
            }
        }
    }

}