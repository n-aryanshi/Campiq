package com.example.studentapp.di

import com.example.studentapp.domain.usecase.LoginUseCase
import com.example.studentapp.domain.usecase.SignUpUseCase
import com.example.studentapp.presentation.viewmodel.AuthViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideAuthViewModel(
        loginUseCase: LoginUseCase,
        signUpUseCase: SignUpUseCase
    ):AuthViewModel{
        return AuthViewModel(loginUseCase, signUpUseCase)
    }
}