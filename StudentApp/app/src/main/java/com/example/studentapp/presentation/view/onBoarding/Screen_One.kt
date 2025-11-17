package com.example.studentapp.presentation.view.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import com.example.studentapp.R
import com.example.studentapp.navigation.Routes

@Composable

fun Screen_one(navHostController: NavHostController) {

    //column{
    //box{
    //button
    //image
    // }
    //text
    //text
    //text
    //button
    //}

    Column(
        modifier = Modifier
            .background(Color(0XFF06919C))
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            //image
            Image(
                painter = painterResource(R.drawable.obs1),
                contentDescription = "screen 1",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .width(413.dp)
                    .height(413.dp)
            )

            //clickable Text - top right corner
            Text(
                text = "Skip",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .clickable(onClick = {navHostController.navigate(Routes.LoginOne){
                        popUpTo(Routes.Screen_Two){
                            inclusive=true
                        }
                    } })
                    .padding(top = 10.dp, end = 10.dp)
            )

        }

//      Text()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween // 👈 centers whole column
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            ColoredText1()

//          Text() - Quick access to rooms and faculty details
            Text(
                text = "Quick access to rooms and faculty details",
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp),
                textAlign = TextAlign.Center
            )


            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Button(
                    onClick = {navHostController.navigate(Routes.Screen_Two)},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,        // Background
                        contentColor = Color(0xFFFF3131) ),    // Text/Icon color (red)
                    modifier = Modifier
                        .align(Alignment.BottomEnd) // works inside Box
                        .padding(end = 32.dp, bottom = 32.dp)

                ) {
                    Text(
                        text = "Next",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.5f), // shadow color
                                offset = Offset(2f, 2f),                // x, y offset
                                blurRadius = 4f                         // softness of shadow
                            ),

                            ),

                        )
                }
            }
        }

    }

}

@Composable
fun ColoredText1() {
    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )) {
            append("Find Your\n")
        }
        withStyle(style = SpanStyle(
            color = Color(0XFFFF3131),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )) {
            append("Class ")
        }
        withStyle(style = SpanStyle(
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )) {
            append("with Ease")
        }
    }

        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge.copy(
                lineHeight = 48.sp, // <-- Increase vertical height of text

                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.5f),
                    offset = Offset(6f, 6f),
                    blurRadius = 4f
                )),
            modifier = Modifier.padding(16.dp)
        )

}


        