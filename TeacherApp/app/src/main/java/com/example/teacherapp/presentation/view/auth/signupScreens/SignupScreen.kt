package com.example.teacherapp.presentation.view.auth.signupScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teacherapp.R
import com.example.teacherapp.presentation.view.auth.loginScreens.CustomOutlineTextField
import com.example.teacherapp.presentation.viewmodel.authviewmodel.AuthViewModel
import com.example.teacherapp.ui.theme.LightGreen
import com.example.teacherapp.ui.theme.PoppinsMedium

//@Preview(showBackground = true)
@Composable
fun SignupScreen(authViewModel: AuthViewModel) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGreen),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.rect_signup_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .padding(top = 150.dp ),
            contentScale = ContentScale.FillBounds
        )

        Box(
            modifier = Modifier
                .size(130.dp)
                .align(Alignment.TopCenter)
                .offset(y = 90.dp), // small push downward
            contentAlignment = Alignment.Center
        ) {
            // Circle background
            Image(
                painter = painterResource(id = R.drawable.teacher2),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )


        }

        SignupScreenView(authViewModel)

    }
}

@Composable
fun SignupScreenView(authViewModel: AuthViewModel) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val authState by authViewModel.authState.collectAsState()

        var id by remember{mutableStateOf("")}
        var email by remember{mutableStateOf("")}
        var password by remember{mutableStateOf("")}
        var phone by remember{mutableStateOf("")}

        Spacer(modifier = Modifier.height(24.dp))

        //id field
        CustomOutlineTextField(
            value=id,
            onValueChange = {id = it},
            t="id",
            keyboardType = KeyboardType.Unspecified
        )

        Spacer(modifier = Modifier.height(18.dp))

        //email text field
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
            t="password",
            keyboardType = KeyboardType.Password,
            isPasswordField = true
        )

        Spacer(modifier = Modifier.height(18.dp))

        //phone number
        CustomOutlineTextField(
            value=phone,
            onValueChange = {phone = it},
            t="phone",
            keyboardType = KeyboardType.Phone
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier.width(260.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = "1 of 2",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Progress bar
        LinearProgressIndicator(
            progress = 0.5f,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(6.dp)
                .clip(RoundedCornerShape(50.dp)),
            color = Color.Red,
            trackColor = Color.LightGray
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Signup button
        Button(
            onClick = {authViewModel.signup(email, password) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .height(54.dp)
                .width(226.dp)
                .shadow(10.dp, RoundedCornerShape(50))
        ) {
            Text("Send OTP", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
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
            Spacer(modifier = Modifier.width(60 .dp))
        }
    }
}



