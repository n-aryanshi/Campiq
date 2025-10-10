package com.example.studentapp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {

    //--------------Login--------------------
    @Serializable
    data object LoginOne: Routes()
    @Serializable
    data object LoginTwo: Routes()
    @Serializable
    data object LoginThree: Routes()
    //--------------Login--------------------

    //--------------Signup--------------------
    @Serializable
    data object SignupScreen: Routes()
    @Serializable
    data object SignupTwo: Routes()
    //--------------Signup--------------------

    //--------------Splash Screen--------------------
    @Serializable
    data object SplashScreen: Routes()
    //--------------Splash Screen--------------------

    //--------------Onboarding Screen--------------------
    @Serializable
    data object Screen_one: Routes()
    @Serializable
    data object Screen_Two: Routes()
    @Serializable
    data object Screen_Three: Routes()
    //--------------Onboarding Screen--------------------

    @Serializable
    data object HomePage: Routes()



}