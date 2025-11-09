package com.example.studentapp.presentation.view.onBoarding

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
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
fun Screen_one(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE9F6D7))

    ) {
        Box {
            Image2(painterResource(R.drawable.obs1))
            Top(navHostController)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(30.dp))
            Text()
            Spacer(Modifier.height(70.dp))
            Bottom(navHostController)

        }


    }
}

@Composable
fun Image2(painter: Painter) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(413.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painter,
            contentDescription = "classRoom",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(413.dp)
                .height(413.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Top(navHostController: NavHostController) {
    TopAppBar(
        title = {},
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .padding(horizontal = 10.dp), horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clickable{
                            navHostController.navigate(Routes.LoginOne)
                        }
                        .background(Color(0xFFCEEE97), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Skip",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFFF3131)
                    )
                }
            }

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        )
    )
}

@Composable
fun Text() {
    Text(
        "Find You",
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
            "Class",
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(Font(R.font.poppin_strike)),
            color = Color(0xFFFF3131),
            style = MaterialTheme.typography.titleLarge,
            letterSpacing = 3.sp
        )
        Spacer(Modifier.width(18.dp))
        Text(
            "Fast",
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
        "See which room and which teacher\nanytime",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
    )

}

@Composable
fun Bottom(navHostController: NavHostController) {
    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), horizontalArrangement = Arrangement.End){
        Box(
            modifier = Modifier
                .clickable{
                    navHostController.navigate(Routes.Screen_Two)
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

