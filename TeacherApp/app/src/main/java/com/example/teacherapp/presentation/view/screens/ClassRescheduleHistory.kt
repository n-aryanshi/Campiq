package com.example.teacherapp.presentation.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentapp.screens.CustomTopBar
import com.example.teacherapp.R
import com.example.teacherapp.ui.theme.PoppinsMedium

@Preview(showBackground = true)
@Composable
fun HistoryScreen() {

    val historyList = listOf(
        Pair("Wed, 16 Dec", "Maths"),
        Pair("Mon, 26 Dec", "Maths"),
        Pair("Wed, 16 Nov", "Maths"),
        Pair("Wed, 16 Dec", "Hindi")
    )

    // Background color for the entire screen
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDFF7D8)) // light green background
//            .padding(horizontal = 16.dp)
    ) {

//        CustomTopBarPreview()
        // CustomTopBar
        CustomTopBar(
            title = "History",
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.history),
                    contentDescription = "Pin",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(36.dp)
                )
            },
            onBackClick = { /* back action */ }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.padding(start=18.dp, end = 18.dp)
        ){// ✅ Title Section - "Class"
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(horizontal = 24.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "Class",
                    fontFamily = PoppinsMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(75.dp))


            // ✅ Scrollable list of items
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(historyList) { (date, subject) ->
                    HistoryItem(date = date, subject = subject)
                }
            }
        }
    }
}

@Composable
fun HistoryItem(date: String, subject: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFFFE9E3)) // soft peach background
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // ✅ Left side: Date + Subject
        Column {
            Text(
                text = date,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Text(
                text = subject,
                fontSize = 16.sp,
                color = Color(0xFF3B26D9), // blue-violet
                fontFamily = PoppinsMedium
            )
        }

        // ✅ Right side: Edit button + Delete icon
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Edit Button
            Button(
                onClick = { /* TODO: Edit Action */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB4F9A8)), // light green
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
            ) {
                Text(
                    text = "Edit",
                    color = Color(0Xff1a9c0c),
                    fontFamily = PoppinsMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            // Delete Icon
            IconButton(onClick = { /* TODO: Delete Action */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = "Delete",
                    tint = Color(0xFFFF4B4B),
                    modifier = Modifier.size(26.dp)
                )
            }
        }
    }
}

@Composable
fun CustomTopBarPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color(0xFFA9E88F)),
        contentAlignment = Alignment.Center
    ) {
        Text("History", fontWeight = FontWeight.Bold, fontSize = 22.sp)
    }
}

