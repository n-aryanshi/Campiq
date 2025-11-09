package com.example.studentapp.presentation.view.onBoarding

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.studentapp.R
import com.example.studentapp.navigation.Routes

@Composable
fun Screen_Two(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE9F6D7))

    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image2(painter = painterResource(R.drawable.obs2))
            Top(navHostController)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(30.dp))
            Text2()
            Spacer(Modifier.height(70.dp))
            Bottom2(navHostController)

        }


    }
}



@Composable
fun Text2() {
    Text(
        "Never Miss",
        fontSize = 50.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily(Font(R.font.poppin_strike)),
        color = Color.Black,
        style = MaterialTheme.typography.titleLarge,
        letterSpacing = 3.sp
    )
    Spacer(Modifier.width(20.dp))
    Row {
        Text(
            "Imp",
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(Font(R.font.poppin_strike)),
            color = Color(0xFFFF3131),
            style = MaterialTheme.typography.titleLarge,
            letterSpacing = 3.sp
        )
        Spacer(Modifier.width(18.dp))
        Text(
            "Info",
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(Font(R.font.poppin_strike)),
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge,
            letterSpacing = 3.sp
        )
    }
    Spacer(Modifier.height(50.dp))
    Text(
        "Get all homework and notices in one\nplace",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
    )

}

@Composable
fun Bottom2(navHostController: NavHostController) {
    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), horizontalArrangement = Arrangement.End){
        Box(
            modifier = Modifier
                .clickable{
                    navHostController.navigate(Routes.Screen_Three)
                }
                .height(50.dp)
                .width(90.dp)
                .background(Color(0xFFCEEE97), RoundedCornerShape(30.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("Next", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFFFF3131))
        }
    }
}

