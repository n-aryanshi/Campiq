package com.example.teacherapp.presentation.view.auth.loginScreens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.teacherapp.R
import com.example.teacherapp.presentation.viewmodel.authviewmodel.AuthViewModel
import com.example.teacherapp.ui.theme.LightGreen
import com.example.teacherapp.ui.theme.PoppinsMedium

@Composable
fun Login1Screen(authViewModel: AuthViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGreen)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets(0)), // 👈 ignore system bars, // 👈 make Box full screen
            contentAlignment = Alignment.Center // 👈 aligns children to bottom
        ) {
            Image(
                painter = painterResource(R.drawable.rect_login_bg),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.62f)
                    .align(Alignment.BottomCenter)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            )

            LoginScreenView(authViewModel)

            // Child sitting on top of wall
            Image(
                painter = painterResource(R.drawable.teacher1),
                contentDescription = "Child sitting",
                modifier = Modifier
                    .width(284.dp)
                    .height(420.dp)
                    //.align(Alignment.BottomCenter)
                    .offset(x = 0.dp, y = -210.dp) // this makes child overlap bottom wall
            )


        }

    }
}

@Composable
fun LoginScreenView(authViewModel: AuthViewModel) {
    var email by remember{mutableStateOf("")}
    var password by remember{mutableStateOf("")}

    val authState by authViewModel.authState.collectAsState()
    Column(
        modifier = Modifier
            .padding(top = 136.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Bottom
    ) {
        Spacer(modifier = Modifier.height(176.dp))

        // Title
        Text(
            text = "Welcome back!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Black,
            color = Color.Black,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Gray,
                    offset = Offset(4f, 4f),
                    blurRadius = 6f
                ),
            ),
            modifier = Modifier.padding(bottom = 18.dp)
        )

        // email field
        CustomOutlineTextField(
            value=email,
            onValueChange = {email = it},
            t="Email",
            keyboardType = KeyboardType.Email
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Password field
        CustomOutlineTextField(
            value=password,
            onValueChange = {password = it},
            t="Password",
            isPasswordField = true,
            keyboardType = KeyboardType.Password
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier.width(260.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = "1 of 3",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
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
            onClick = { authViewModel.login(email, password)},
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
                color = Color.Black,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Gray,
                        offset = Offset(4f, 4f),
                        blurRadius = 6f
                    ),
                ),
            )
            //clickable
            Text(
                "Sign Up",
                fontSize = 17.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text("OR", fontSize = 25.sp, color = Color.Black, fontWeight = FontWeight.ExtraBold)

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
                painter = painterResource(id = R.drawable.google), // Google logo in drawable
                contentDescription = "Google",
                tint = Color.Unspecified,
                modifier = Modifier.size(width = 33.dp, height = 33.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Continue with Google",
                color = Color.Gray,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun CustomOutlineTextField(
    value:String,
    onValueChange:(String)-> Unit,
    t:String,
    isPasswordField:Boolean = false,
    keyboardType: KeyboardType
){

    var passwordVisibile by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = t,
                color =  Color.Black,
                fontFamily = PoppinsMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier.padding(top=4.dp, bottom=4.dp, start = 16.dp)
            )
        },
        singleLine = true,
        trailingIcon = {
            if(isPasswordField){
                val icon = if(passwordVisibile) Icons.Default.Visibility
                            else Icons.Default.VisibilityOff

                val description = if(passwordVisibile) "Hide Password"
                            else "Show Password"

                IconButton(onClick = {passwordVisibile = !passwordVisibile}) {
                    Icon(
                        imageVector = icon, contentDescription = description,

                    )
                }
            }
        },

        visualTransformation = if(isPasswordField && passwordVisibile == true){
                                    PasswordVisualTransformation()
                                }else{
                                    VisualTransformation.None
                                } ,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),


        modifier = Modifier
            .shadow(8.dp, RoundedCornerShape(50))
            .width(280.dp).height(70.dp),
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor =  Color.White,
            unfocusedContainerColor =  Color.White,
            disabledContainerColor =  Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )

    )

}


