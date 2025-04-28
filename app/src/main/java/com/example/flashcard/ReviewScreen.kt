package com.example.flashcard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ReviewScreen(navController: NavController, userName: String, userAnswers: List<Boolean>, correctAnswers: List<Boolean>) {
    Column(
        modifier =
            Modifier.fillMaxSize()
                    .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "$userName's Review",
            style = TextStyle(
                color = Color.Black,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                shadow = Shadow(
                    color = Color(0xFF47A572),
                    offset = Offset(0f, 0f),
                    blurRadius = 20f
                )
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Display each question and the user's answer
        val questions = listOf(
            "The sum of the angles in a triangle is always 180 degrees",
            "The Declaration of Independence was signed in 1776",
            "'Moby Dick was' written by Mark Twain",
            "Mount Everest is the tallest mountain in the world",
            "DNA stands for Deoxyribonucleic Acid",
            "Humans have 4 lungs"
        )

        for (index in userAnswers.indices) {
            val questionText = questions[index]
            val userAnswer = userAnswers[index]
            val correctAnswer = correctAnswers[index]

            // Determine the background color based on the answer
            val backgroundColor = if (userAnswer == correctAnswer) Color(0xFF3DDD7F) else Color.Red

            // Create a bubble effect for the question
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(color = backgroundColor, shape = MaterialTheme.shapes.medium) // Rounded corners
                    .padding(16.dp) // Padding inside the bubble
            ) {
                Text(
                    text = "$questionText - Your answer: ${if (userAnswer == true) "True" else "False"}",
                    color = Color.White, // White text color
                    fontSize = 20.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Button to navigate back to Home
        Button(onClick = {
            navController.navigate(Routes.Home)
        },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A275D))
        ) {
            Text(text = "Exit", color = Color.White)
        }
    }
}

