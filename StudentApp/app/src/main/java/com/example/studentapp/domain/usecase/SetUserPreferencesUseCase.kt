package com.example.studentapp.domain.usecase

import com.example.studentapp.domain.repository.UserPreferencesRepository
import jakarta.inject.Inject


class SetUserPreferencesUseCase   @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) {
    
    suspend fun setFirstTimeLogin(isFirstTime: Boolean) {
        userPreferencesRepository.setFirstTimeLogin(isFirstTime)
    }
    
    suspend fun setLoggedIn(isLoggedIn: Boolean) {
        userPreferencesRepository.setLoggedIn(isLoggedIn)
    }
}
