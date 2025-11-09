package com.example.studentapp.data.repository

import com.example.studentapp.data.local.UserPreferencesDataStore
import com.example.studentapp.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow

class UserPreferencesRepositoryImpl(
    private val userPreferencesDataStore: UserPreferencesDataStore
) : UserPreferencesRepository {
    
    override val isFirstTimeLogin: Flow<Boolean> = userPreferencesDataStore.isFirstTimeLogin
    
    override val isLoggedIn: Flow<Boolean> = userPreferencesDataStore.isLoggedIn
    
    override suspend fun setFirstTimeLogin(isFirstTime: Boolean) {
        userPreferencesDataStore.setFirstTimeLogin(isFirstTime)
    }
    
    override suspend fun setLoggedIn(isLoggedIn: Boolean) {
        userPreferencesDataStore.setLoggedIn(isLoggedIn)
    }
}
