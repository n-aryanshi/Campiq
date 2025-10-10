package com.example.studentapp.di

import com.example.studentapp.domain.repository.AuthRepository
import com.example.studentapp.domain.usecase.LoginUseCase
import com.example.studentapp.domain.usecase.SignUpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    @ViewModelScoped
    fun provideLoginUseCase(authRepository: AuthRepository):LoginUseCase{
        return LoginUseCase(authRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideSignupUseCase(authRepository: AuthRepository):SignUpUseCase{
        return  SignUpUseCase(authRepository)
    }

}