package com.example.class_management_system.presentation.view.screens.OnBoarding


import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.class_management_system.R

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true)
fun ThirdScreen(modifier: Modifier = Modifier) {

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
        modifier = modifier
            .background(Color(0XFF06919C))
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            //image
            Image(
                painter = painterResource(R.drawable.obs3),
                contentDescription = "screen 3",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .width(413.dp)
                    .height(413.dp)
            )

            //clickable Text - top right corner
            Text(
                text = "Skip",
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .clickable(onClick = {})
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
            ColoredTextFin()

//          Text() - Quick access to rooms and faculty details
            Text(
                text = "Get Notified before your class Starts",
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp),
                textAlign = TextAlign.Center
            )




            Spacer(modifier = Modifier.height(8.dp))

            // ✅ Button pinned at bottom right
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Button(
                    onClick = {},
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
fun ColoredTextFin() {
    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )) {
            append("Smart Class\n")
        }
        withStyle(style = SpanStyle(
            color = Color(0XFFFF3131),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )) {
            append("Reminder ")
        }
    }

    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineLarge.copy(
            lineHeight = 48.sp, // <-- Increase vertical height of text
            fontWeight = FontWeight.ExtraBold,
            shadow = Shadow(
                color = Color.Black.copy(alpha = 0.5f),
                offset = Offset(6f, 6f),
                blurRadius = 4f
            )),
        modifier = Modifier.padding(16.dp),



    )

}


