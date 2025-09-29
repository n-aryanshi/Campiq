package com.example.studentapp.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studentapp.R
import com.example.studentapp.ui.theme.LightTeal


data class TimeTableItem(
    val slotNumber: Int,
    val subject: String,
    val faculty: String,
    val time: String,
)

val ProtestStrike = FontFamily(
    Font(R.font.protest_strike_regular)
)

@Composable
fun TimeTableRow(item: TimeTableItem, color: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp)
            .background(color, RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Slot number
        Text(
            text = item.slotNumber.toString(),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(end = 12.dp)
        )

        Column {
            Text(
                text = item.subject,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = ProtestStrike
                )
            )

            // ✅ faculty name below subject
            Text(
                text = item.faculty,
                style = MaterialTheme.typography.bodyMedium.copy(fontStyle = FontStyle.Italic)
            )

            Text(
                text = item.time,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeTableScreen(items: List<TimeTableItem>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0097A7)) // your teal background
    ) {
        // Top bar is static
        TopAppBar(
            title = {
                Text(
                    "Time Table",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = ProtestStrike,
                        fontWeight = FontWeight.Bold
                    )
                )
            },
            navigationIcon = {
                IconButton(onClick = { /* back action */ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            actions = {
                Icon(
                    painter = painterResource(id = R.drawable.pushpin),
                    contentDescription = "Pin",
                    tint = Color.Unspecified
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = LightTeal
            )
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            items(items) { item ->
                TimeTableRow(item, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TimeTableScreenPreview() {
    val sampleItems = listOf(
        TimeTableItem(1, "Math", "Mr. Sharma", "9:00 AM - 9:45 AM"),
        TimeTableItem(2, "Physics", "Ms. Mehta", "9:50 AM - 10:35 AM"),
        TimeTableItem(3, "Chemistry", "Mr. Verma", "10:40 AM - 11:25 AM")
    )

    TimeTableScreen(items = sampleItems)
}


