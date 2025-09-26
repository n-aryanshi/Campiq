package com.example.class_management_system.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.class_management_system.data.repository.AuthRepositoryImpl
import com.example.class_management_system.domain.repository.AuthRepository
import com.example.class_management_system.domain.usecase.LoginUseCase
import com.example.class_management_system.domain.usecase.SignUpUseCase
import com.example.class_management_system.presentation.view.auth.loginScreens.LoginOne
import com.example.class_management_system.presentation.view.auth.loginScreens.LoginThree

import com.example.class_management_system.presentation.view.auth.loginScreens.LoginTwo
import com.example.class_management_system.presentation.view.auth.signupScreen.SignupScreen
import com.example.class_management_system.presentation.view.home.HomePage
import com.example.class_management_system.presentation.view.onBoarding.Screen_Three
import com.example.class_management_system.presentation.view.onBoarding.Screen_Two
import com.example.class_management_system.presentation.view.onBoarding.Screen_one
import com.example.class_management_system.presentation.view.screens.LoginScreens.SignupTwo
import com.example.class_management_system.presentation.view.splashScreen.SplashScreen
import com.example.class_management_system.presentation.viewmodel.AuthViewModel
import com.google.firebase.auth.FirebaseAuth


@SuppressLint("NewApi")
@Composable
fun Navigation(){
    val navHostController= rememberNavController()

    //----------------AuthViewModel Factory----------------------
    // Repository & UseCases
    val authRepositoryImpl = AuthRepositoryImpl(FirebaseAuth.getInstance())
    val loginUseCase = LoginUseCase(authRepositoryImpl)
    val signUpUseCase = SignUpUseCase(authRepositoryImpl)

    // Local ViewModelFactory inside the function
    val authViewModel: AuthViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return AuthViewModel(loginUseCase, signUpUseCase) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    )


    NavHost(navController = navHostController, startDestination = Routes.SplashScreen){

        //--------------Splash Screen--------------------
        composable<Routes.SplashScreen> {
            SplashScreen(navHostController)
        }
        //--------------Splash Screen--------------------


        //--------------Login--------------------
        composable<Routes.LoginOne> {
             LoginOne(navHostController,authViewModel)
        }
        composable<Routes.LoginTwo> {
            LoginTwo(navHostController)
        }
        composable<Routes.LoginThree> {
            LoginThree()
        }
        //--------------Login--------------------


        //--------------Signup--------------------
        composable<Routes.SignupScreen> {
            SignupScreen(navHostController,authViewModel)
        }
        composable<Routes.SignupTwo> {
            SignupTwo()
        }
        //--------------Signup--------------------

        //-------Onboarding Screen---------------
        composable<Routes.Screen_one> {
            Screen_one(navHostController)
        }
        composable<Routes.Screen_Two> {
            Screen_Two(navHostController)
        }
        composable<Routes.Screen_Three> {
            Screen_Three(navHostController)
        }
        //-------Onboarding Screen---------------
        composable<Routes.HomePage> {
            HomePage()
        }
    }
}