package com.example.flashcard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScoreScreen(navController: NavController, score: Int, userName: String, userAnswers: List<Boolean>) {
    Column(
        modifier =
            Modifier.fillMaxSize()
                    .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display the score
        Text(
            text = "Score Board",
            style = TextStyle(
                color = Color.Black,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                shadow = Shadow(
                    color = Color(0xFF00C4B4),
                    offset = Offset(0f, 0f),
                    blurRadius = 20f
                )
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "$userName's final score is: $score/6",
            style = TextStyle(
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(25.dp))

        // Button to navigate to the Review Screen
        Button(onClick = {
            // Pass userName and userAnswers as a comma-separated string
            navController.navigate("review_screen/$userName/${userAnswers.joinToString(",")}")
        },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A275D))
        ) {
            Text(text = "Review Answers", color = Color.White)
        }
    }
}


