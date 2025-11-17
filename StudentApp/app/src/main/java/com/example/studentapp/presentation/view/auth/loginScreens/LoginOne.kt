package com.example.studentapp.presentation.view.auth.loginScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.studentapp.R
import com.example.studentapp.navigation.Routes
import com.example.studentapp.presentation.viewmodel.AuthViewModel
import com.example.studentapp.util.Result

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginOne(navHostController: NavHostController, authViewModel: AuthViewModel) {
    val authState by authViewModel.authState.collectAsState()
    var loading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    // React to authState changes
    LaunchedEffect(authState) {
        when (val state = authState) {
            is Result.Success -> {
                loading = false
                delay(500)
                navHostController.navigate(Routes.HomePage) {
                    popUpTo(Routes.LoginOne) { inclusive = true }
                }
            }

            is Result.Failure -> {
                loading = false
                errorMessage = state.message
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(errorMessage!!)
                }
            }

            is Result.Loading -> {
                loading = true
                errorMessage = null
            }

            else -> {
                loading = false
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFF06919C))
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(WindowInsets(0)),
                contentAlignment = Alignment.Center
            ) {
                // Background wall
                Image(
                    painter = painterResource(R.drawable.rectangle_5),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                )

                // Login form
                LoginScreenView(navHostController,authViewModel)

                // Child sitting on wall
                Image(
                    painter = painterResource(R.drawable.child),
                    contentDescription = "Child sitting",
                    modifier = Modifier
                        .width(254.dp)
                        .height(380.dp)
                        .offset(x = -30.dp, y = -210.dp)
                )

                // Loading indicator
                if (loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.White,
                        strokeWidth = 3.dp
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreenView(navHostController: NavHostController,authViewModel: AuthViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordHidden by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .padding(top = 136.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(136.dp))

        // Title
        Text(
            text = "Welcome back!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Black,
            color = Color.White,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Gray,
                    offset = Offset(4f, 4f),
                    blurRadius = 6f
                )
            ),
            modifier = Modifier.padding(bottom = 18.dp)
        )

        // Username field
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = {
                Text(
                    text = "Username",
                    color = Color(0XFF06919C),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
            },
            modifier = Modifier
                .width(280.dp)
                .height(50.dp)
                .shadow(8.dp, RoundedCornerShape(50)),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFB5E6ED),
                unfocusedContainerColor = Color(0xFFB5E6ED),
                disabledContainerColor = Color(0xFFB5E6ED),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Password field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(
                    text = "Password",
                    color = Color(0XFF06919C),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = if (passwordHidden) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = "Toggle password visibility",
                    modifier = Modifier.clickable { passwordHidden = !passwordHidden }
                )
            },
            visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier
                .shadow(8.dp, RoundedCornerShape(50))
                .width(280.dp)
                .height(50.dp),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFB5E6ED),
                unfocusedContainerColor = Color(0xFFB5E6ED),
                disabledContainerColor = Color(0xFFB5E6ED),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Step indicator
        Box(
            modifier = Modifier.width(260.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = "1 of 3",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Progress bar
        LinearProgressIndicator(
            progress = 0.33f,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(6.dp)
                .clip(RoundedCornerShape(50.dp)),
            color = Color.Red,
            trackColor = Color.LightGray
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Login button
        Button(
            onClick = {
               authViewModel.login(username,password)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .height(54.dp)
                .width(226.dp)
                .shadow(10.dp, RoundedCornerShape(50))
        ) {
            Text("Login", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Sign Up
        Row {
            Text(
                "Don't have an account? ",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Gray,
                        offset = Offset(4f, 4f),
                        blurRadius = 6f
                    )
                )
            )
            Text(
                "Sign Up",
                fontSize = 17.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navHostController.navigate(Routes.SignupScreen) {
                        popUpTo(Routes.LoginOne) { inclusive = true }
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text("OR", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.ExtraBold)

        Spacer(modifier = Modifier.height(14.dp))

        // Google login button
        OutlinedButton(
            onClick = { },
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .width(266.dp)
                .height(48.dp)
                .shadow(8.dp, RoundedCornerShape(50)),
            border = BorderStroke(1.dp, Color.LightGray),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White),
            contentPadding = PaddingValues(0.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                tint = Color.Unspecified,
                modifier = Modifier.size(width = 33.dp, height = 33.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Continue with Google", color = Color.Gray, fontSize = 20.sp)
        }
    }
}


