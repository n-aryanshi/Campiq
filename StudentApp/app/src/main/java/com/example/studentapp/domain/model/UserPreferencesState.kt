package com.example.studentapp.domain.model

data class UserPreferencesState(
    val isFirstTimeLogin: Boolean = true,
    val isLoggedIn: Boolean = false,
    val isLoading: Boolean = true
)
