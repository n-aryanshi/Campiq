package com.example.class_management_system.presentation.view.screens.SplashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.class_management_system.R


@Composable
fun MiddleBox() {
    Box{
        Image(
            painter = painterResource(R.drawable.splash_bg),
            contentDescription = "splash",
            modifier = Modifier.height(224.dp).width(224.dp)
        )

        Image(
            painter = painterResource(R.drawable.splash),
            contentDescription = "splash",
            modifier = Modifier.height(241.dp).width(185.dp)
        )
    }
    
}

@Composable
@Preview
fun FullScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0097A7)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


    ){
        MiddleBox()
        NoticesTitle()
        
    }
    
}

@Composable
fun NoticesTitle() {
    Box(
        modifier = Modifier
            .padding(16.dp).height(85.dp).width(269.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontSize = 70.sp
                    )
                ) {
                    append("N")
                }

                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                                fontSize = 70.sp
                    )
                ) {
                    append("oti")
                }

                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontSize = 70.sp
                    )
                ) {
                    append("c")
                }

                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 70.sp
                    )
                ) {
                    append("es")
                }
            },
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Gray,
                    offset = Offset(6f, 6f),
                    blurRadius = 4f
                )
            )
        )
    }
}
