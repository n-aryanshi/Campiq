package com.example.studentapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentapp.domain.usecase.LoginUseCase
import com.example.studentapp.domain.usecase.SignUpUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.studentapp.util.Result
class AuthViewModel(
    private val loginUseCase: LoginUseCase,
    private val signUpUseCase: SignUpUseCase
):ViewModel() {
    private val _authState = MutableStateFlow<Result<String>>(Result.Idle)//
    val authState: StateFlow<Result<String>> = _authState

    fun login(email: String, password: String) {
        _authState.value = Result.Loading
        viewModelScope.launch {
            try {
                val result = loginUseCase(email, password)
                _authState.value = result
            } catch (e: Exception) {
                _authState.value = Result.Failure(e.message ?: "Login failed")
            }
        }
    }

    fun signup(email: String, password: String) {
        _authState.value = Result.Loading
        viewModelScope.launch {
            try {
                val result =signUpUseCase(email, password)
                _authState.value = result
            } catch (e: Exception) {
                _authState.value = Result.Failure(e.message ?: "Signup failed")
            }
        }
    }
}