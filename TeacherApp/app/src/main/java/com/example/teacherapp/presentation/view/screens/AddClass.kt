package com.example.teacherapp.presentation.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teacherapp.R
import android.app.TimePickerDialog
import android.widget.TimePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.teacherapp.ui.theme.LightGreen
import java.util.*
import com.example.teacherapp.ui.theme.PoppinsMedium
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AddClassColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.width(360.dp).height(600.dp)
            .padding(8.dp)
    ){

        //Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0XFFFFE9D6))
                .padding(16.dp)
        ) {
            CustomTextField(
                "Subject",
                "Subject",
                painterResource(id = R.drawable.subject)
            )
            CustomTextField(
                "Topic",
                "Topic",
                painterResource(id = R.drawable.topic)
            )
            CustomTextField(
                "Class",
                "Class",
                painterResource(id = R.drawable.classroom)
            )
            CustomTextField(
                "Room No.",
                "Room No.",
                painterResource(id = R.drawable.room)
            )

            Row(
                modifier = Modifier.padding(8.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TimeSelector()
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = "User icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(51.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                TimeSelector()
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth().padding(top = 12.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .size(146.dp,56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF06919C) // Teal color
                    ),
                ) {
                    Text(
                        text ="ADD",
                        fontFamily = PoppinsMedium,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(3.dp)
                    )
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    label: String,
    placeholder: String,
    icon: Painter
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 14.dp),
//        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        OutlinedTextField(
            value = "",
            onValueChange = {},

            leadingIcon = {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(30.dp)
                )
            },
            label = {Text( label , color = Color.Black, fontFamily = PoppinsMedium, fontSize = 25.sp)},
            placeholder = {Text (placeholder, color = Color.Black, fontFamily = PoppinsMedium, fontSize = 25.sp) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedPlaceholderColor = Color.Black,
                unfocusedPlaceholderColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth(),
        )
    }

}

@Composable
fun TimeSelector(
    //label: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    // Selected time
    var selectedTime by remember { mutableStateOf("") }

    // Time Picker Dialog
    val timePickerDialog = TimePickerDialog(
        context,
        { _: TimePicker, hour: Int, minute: Int ->
            val formattedHour = String.format("%02d", hour)
            val formattedMinute = String.format("%02d", minute)
            selectedTime = "$formattedHour:$formattedMinute"
        },
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        true
    )

    // UI
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(
                color = Color.White, // background color
                shape = RoundedCornerShape(8.dp) // 0.dp for perfect rectangle
            )
            .clickable { timePickerDialog.show() }

    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = if (selectedTime.isEmpty()) "HH:MM" else selectedTime,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun FullScreen(){
    val systemUiController = rememberSystemUiController()

    // ✅ Apply system bar colors (status & navigation bars)
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.White, // status + nav bar
            darkIcons = true      // icons remain dark for contrast
        )
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGreen),
        contentWindowInsets = WindowInsets.systemBars // ✅ respects top/bottom bars
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // your UI code here...
            Spacer(modifier = Modifier.height(70.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(top = 24.dp, bottom = 12.dp, start = 28.dp, end = 28.dp),
            ) {
                //text
                Text(
                    text = "Add Class",
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    fontFamily = PoppinsMedium
                )

                Spacer(modifier = Modifier.weight(1f))
                //icon
                Icon(
                    painter = painterResource(id = R.drawable.history),
                    contentDescription = "User icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(38.dp)
                )
            }
            AddClassColumn()
        }
    }
}
