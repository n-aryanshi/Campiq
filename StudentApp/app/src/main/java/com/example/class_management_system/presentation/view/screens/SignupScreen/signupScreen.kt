package com.example.class_management_system.presentation.view.screens.LoginScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.class_management_system.R

@Preview(showBackground = true)
@Composable
fun signupBg(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0XFF06919C)),
        contentAlignment = Alignment.Center
    ) {
            Image(
                painter = painterResource(R.drawable.rect_2),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .width(345.dp).height(909.dp)
                    .align(Alignment.TopCenter)
                    .padding(top = 90.dp, start = 18.dp, end = 18.dp, bottom = 110.dp),
                contentScale = ContentScale.FillBounds
            )

            Box(
                modifier = Modifier
                    .size(130.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 30.dp), // small push downward
                contentAlignment = Alignment.Center
            ) {
                // Circle background
                Image(
                    painter = painterResource(id = R.drawable.bg_hat),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )

                // Hat image
                Image(
                    painter = painterResource(id = R.drawable.convo_hat),
                    contentDescription = "Graduation Hat",
                    modifier = Modifier.size(127.dp) // adjust size
                )
            }

            SignupScreenView()






    }
}

@Composable
fun SignupScreenView() {
    Column(
        modifier = Modifier
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "College Id",
                    color = Color(0XFF06919C),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
            },
            modifier = Modifier
                .width(280.dp).height(50.dp)
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


        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Email",
                    color = Color(0XFF06919C),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
            },
            modifier = Modifier
                .width(280.dp).height(50.dp)
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
            value = "",
            onValueChange = {},
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
                    imageVector = Icons.Default.VisibilityOff,
                    contentDescription = "Password visibility"
                )
            },

            modifier = Modifier
                .shadow(8.dp, RoundedCornerShape(50))
                .width(280.dp).height(50.dp),
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

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Phone number",
                    color = Color(0XFF06919C),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
            },
            modifier = Modifier
                .width(280.dp).height(50.dp)
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

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier.width(260.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = "1 of 2",
                fontWeight = FontWeight.Bold,
                color = Color.White,
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

        // Login button
        Button(
            onClick = { },
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



