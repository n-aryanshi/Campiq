package com.example.studentapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentapp.R
import com.example.studentapp.ui.theme.PoppinsMedium
import com.example.studentapp.ui.theme.ProtestStrike
import com.example.studentapp.ui.theme.Teal

@Preview(showBackground = true)
@Composable
fun SlotDetailsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Teal) // background color like in image
    ) {
        // Top Bar
        CustomTopBar(
            title = "Details",
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.info),
                    contentDescription = "info",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(36.dp)
                )
            },
            onBackClick = { /* back action */ }
        )


        // Class Info Card

            Box(
                modifier = Modifier
                    .fillMaxWidth().padding(10.dp)
                    .background(Teal) // fallback if image not loaded
            ) {
                // Background Image
                androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.crushedpaper), // your background image
                    contentDescription = "Class Background",
                    modifier = Modifier.fillMaxWidth().padding(24.dp),
                    contentScale = ContentScale.Crop // makes image cover full card
                )

                // Foreground Texts
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    Text(
                        text ="Class Info",
                        fontSize = 40.sp,
                        fontFamily = PoppinsMedium,
                        modifier = Modifier.padding(top = 12.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Teacher - Ms. Carols", fontSize = 27.sp, fontFamily = PoppinsMedium)
                    Spacer(modifier = Modifier.height(2.dp))

                    Text("Subject - Maths", fontSize = 27.sp, fontFamily = PoppinsMedium)
                    Spacer(modifier = Modifier.height(2.dp))

                    Text("Room No - 20A", fontSize = 27.sp, fontFamily = PoppinsMedium)
                    Spacer(modifier = Modifier.height(10.dp))


                    // Topic Section
                    Text("Topic", fontSize = 40.sp, fontFamily = ProtestStrike, color = Color.Red)
                    Spacer(modifier = Modifier.height(4.dp))

                    Text("Intro to Graphs", fontSize = 25.sp, fontFamily = PoppinsMedium,)
                    Spacer(modifier = Modifier.height(4.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 36.dp, end = 36.dp)
                            .height(130.dp) // fixed rectangle height
                            .background(
                                color = Color(0xFFD9D9D9),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp) // inner padding
                    ) {
                        val scrollState = rememberScrollState()

                        Text(
                            text = "Intro to Graphs1...\n" +
                                    "Intro to Graphs2...\n" +
                                    "Intro to Graphs3...\n" +
                                    "Intro to Graphs4...\n" +
                                    "Intro to Graphs5...\n" +
                                    "Intro to Graphs6...\n" +
                                    "Intro to Graphs7...\n",
                            fontFamily = PoppinsMedium,
                            fontSize = 18.sp,
                            modifier = Modifier.verticalScroll(scrollState) // ✅ scrollable content
                        )
                    }


                    // Button
                    Button(
                        onClick = { /* TODO: Use Campiq AI */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        modifier = Modifier.fillMaxWidth().padding(top = 24.dp, start = 36.dp, end = 36.dp),
                        shape = RoundedCornerShape(30.dp)
                    ) {
                        Text("Use Campiq AI to More", color = Color.White)
                    }
                }
            }


    }
}
