package com.example.studentapp.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.class_management_system.presentation.view.onBoarding.Screen_Three

import com.example.studentapp.presentation.view.auth.loginScreens.LoginOne
import com.example.studentapp.presentation.view.auth.loginScreens.LoginThree
import com.example.studentapp.presentation.view.auth.loginScreens.LoginTwo
import com.example.studentapp.presentation.view.auth.signupScreen.SignupScreen
import com.example.studentapp.presentation.view.auth.signupScreen.SignupTwo
import com.example.studentapp.presentation.view.home.HomeScreen
import com.example.studentapp.presentation.view.onBoarding.Screen_Two
import com.example.studentapp.presentation.view.onBoarding.Screen_one
import com.example.studentapp.presentation.view.splashScreen.SplashScreen
import com.example.studentapp.presentation.viewmodel.AuthViewModel
import com.example.studentapp.presentation.viewmodel.UserPreferencesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel


@SuppressLint("NewApi")
@Composable
fun Navigation() {
    val navHostController = rememberNavController()

    //----------------AuthViewModel----------------------
    val authViewModel: AuthViewModel = hiltViewModel()

    //----------------UserPreferenceViewModel----------------------
    val userPreferencesViewModel: UserPreferencesViewModel = hiltViewModel()
    // Observe user preferences state
    val userPreferencesState by userPreferencesViewModel.state.collectAsState()
    NavHost(navController = navHostController, startDestination = Routes.SplashScreen) {

        //--------------Splash Screen--------------------
        composable<Routes.SplashScreen> {
            SplashScreen(
                onFinish = {
                    val destination = when {
                        userPreferencesState.isLoggedIn -> Routes.HomePage
                        userPreferencesState.isFirstTimeLogin -> Routes.Screen_one
                        else -> Routes.LoginOne
                    }
                    navHostController.navigate(destination) {
                        popUpTo(Routes.SplashScreen) { inclusive = true }
                    }
                }
            )
        }
        //--------------Splash Screen--------------------


        //--------------Login--------------------
        composable<Routes.LoginOne> {
            LoginOne(navHostController, authViewModel, userPreferencesViewModel)
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
            SignupScreen(navHostController, authViewModel, userPreferencesViewModel)
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
            HomeScreen(navHostController, userPreferencesViewModel)
        }
    }
}