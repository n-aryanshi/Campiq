package com.example.studentapp.domain.usecase

import com.example.studentapp.domain.repository.UserPreferencesRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetUserPreferencesUseCase   @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) {
    
    fun isFirstTimeLogin(): Flow<Boolean> = userPreferencesRepository.isFirstTimeLogin
    
    fun isLoggedIn(): Flow<Boolean> = userPreferencesRepository.isLoggedIn
}
