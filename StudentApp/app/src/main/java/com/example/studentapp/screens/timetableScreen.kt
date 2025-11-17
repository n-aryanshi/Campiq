package com.example.studentapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentapp.R
import com.example.studentapp.ui.theme.ProtestStrike
import com.google.accompanist.systemuicontroller.rememberSystemUiController


data class TimeTableItem(
    val slotNumber: Int,
    val subject: String,
    val time: String,
)

val slotColors = listOf(
    Color(0xFF7BF59C), // Slot 1,4,7
    Color(0xFFFEDA71), // Slot 2,5,8
    Color(0xFFEA83E1)  // Slot 3,6
)


@Composable
fun TimeTableRow(item: TimeTableItem, color: Color) {
    Row(
        modifier = Modifier.size(258.dp, 85.dp)
            .background(color, RoundedCornerShape(20.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Slot number
        Text(
            text = item.slotNumber.toString(),
            fontSize = 25.sp,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.SemiBold,
                fontFamily = ProtestStrike),
            modifier = Modifier.padding(end = 12.dp)
        )

        Spacer(modifier = Modifier.width(64.dp))

        Column {
            Text(
                text = item.subject,
                fontSize = 30.sp,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = ProtestStrike
                )
            )

            Text(
                text = "(${item.time})",
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Medium,
                    fontFamily = ProtestStrike
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeTableScreen(items: List<TimeTableItem>) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = false // since your top bar is teal, keep icons light

    // Hide status bar only on this screen
    SideEffect {
        systemUiController.isStatusBarVisible = false
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0097A7)) // your teal background
    ) {
        // custom Top bar
        CustomTopBar(
            title = "Time Table",
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.pushpin),
                    contentDescription = "Pin",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(36.dp)
                )
            },
            onBackClick = { /* back action */ }
        )


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 12.dp),

            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(items) { item ->
                val color = slotColors[(item.slotNumber - 1) % slotColors.size]
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 16.dp), // ✅ padding from screen edges,
                    contentAlignment = if (item.slotNumber % 2 == 1) {
                        Alignment.CenterStart  // odd → left
                    } else {
                        Alignment.CenterEnd    // even → right
                    }
                ) {
                    TimeTableRow(item, color)
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun TimeTableScreenPreview() {
    val sampleItems = listOf(
        TimeTableItem(1, "Math",  "9:00 AM - 9:45 AM"),
        TimeTableItem(2, "Physics",  "9:50 AM - 10:35 AM"),
        TimeTableItem(3, "Chemistry",  "10:40 AM - 11:25 AM"),
        TimeTableItem(4, "Math",  "9:00 AM - 9:45 AM"),
        TimeTableItem(5, "Physics",  "9:50 AM - 10:35 AM"),
        TimeTableItem(6, "Chemistry",  "10:40 AM - 11:25 AM"),
        TimeTableItem(7, "Math", "9:00 AM - 9:45 AM"),
        TimeTableItem(8, "Physics",  "9:50 AM - 10:35 AM"),

    )

    TimeTableScreen(items = sampleItems)
}


