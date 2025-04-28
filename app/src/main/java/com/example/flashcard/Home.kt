package com.example.flashcard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Shadow
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource

@Composable
fun Home(navController: NavController) {
    var userName by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Flash Card Game",
            style = TextStyle(
                color = Color.Black, // Black text color
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                shadow = Shadow(
                    color = Color.White, // Glow color
                    offset = Offset(0f, 0f), // No offset
                    blurRadius = 10f // Adjust blur radius for glow effect
                )
            ),
            textAlign = TextAlign.Center // Center the text
        )

        Image(
            painter = painterResource(id = R.drawable.bg_main),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        )

        TextField(
            value = userName,
            onValueChange = { newValue: TextFieldValue -> userName = newValue },
            label = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        Button(onClick = {
            navController.navigate("question_screen/${userName.text}")
        }) {
            Text(text = "Start Game")
        }
    }
}
