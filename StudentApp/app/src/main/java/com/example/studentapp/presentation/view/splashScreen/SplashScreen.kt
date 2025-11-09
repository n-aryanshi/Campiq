package com.example.studentapp.presentation.view.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentapp.R

@Composable
fun SplashScreen(
    onFinish: () -> Unit
) {
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000) // optional 2-second splash delay
        onFinish()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE9F6D7)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Image(
            painter = painterResource(R.drawable.main_logo),
            contentDescription = "Main Logo",
            modifier = Modifier.size(200.dp)
        )
        Campiq()
    }
}

@Composable
fun Campiq() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            "Ca",
            color = Color(0xFFFF3131),
            fontSize = 70.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(
                Font(R.font.protest_strike)
            ),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            "mp",
            color = Color.Black,
            fontSize = 70.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(
                Font(R.font.protest_strike)
            ),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            "i",
            color = Color(0xFFFF3131),
            fontSize = 70.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(
                Font(R.font.protest_strike)
            ),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            "q",
            color = Color.Black,
            fontSize = 70.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(
                Font(R.font.protest_strike)
            ),
            style = MaterialTheme.typography.titleLarge
        )
    }
}



