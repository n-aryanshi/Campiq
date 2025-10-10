plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization") version "2.2.0"//Serialization
    alias(libs.plugins.google.gms.google.services)//AuthFireBase
    id("com.google.devtools.ksp")//Hilt Ksp(All @Annotation File)
    id("com.google.dagger.hilt.android")//Compiler

}

android {
    namespace = "com.example.studentapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.studentapp"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    //-----------System Define--------------------------
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.auth)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //---------User Define-------------------------------
    implementation(libs.androidx.navigation.compose)//Navigation
    implementation(libs.kotlinx.serialization.json)//Serialization
    implementation(libs.androidx.material.icons.extended)//Icons Extend
    implementation(libs.hilt.android)//Hilt Compiler
    ksp(libs.hilt.android.compiler)//Hilt Ksp(All @Annotation File)
    implementation(libs.androidx.hilt.navigation.compose)//Hilt For Compose




}