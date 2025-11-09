package com.example.studentapp.di

import android.content.Context
import com.example.studentapp.data.local.UserPreferencesDataStore
import com.example.studentapp.data.repository.AuthRepositoryImpl
import com.example.studentapp.data.repository.UserPreferencesRepositoryImpl
import com.example.studentapp.domain.repository.AuthRepository
import com.example.studentapp.domain.repository.UserPreferencesRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module/**/
//ViewModelComponent
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth():FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideAuthRepository(firebaseAuth: FirebaseAuth):AuthRepository{
        return AuthRepositoryImpl(firebaseAuth)
    }
    @Provides
    @Singleton
    fun provideUserPreferencesDataStore(@ApplicationContext context: Context): UserPreferencesDataStore {
        return UserPreferencesDataStore(context)
    }

    @Provides
    @Singleton
    fun provideUserPreferences(userPreferencesDataStore: UserPreferencesDataStore):UserPreferencesRepository{
        return UserPreferencesRepositoryImpl(userPreferencesDataStore)
    }

}


































