package com.example.flashcard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
fun QuestionScreen(navController: NavController, userName: String) {
    // Define the questions
    val questions = listOf(
        "Is the sky blue?",
        "Is water wet?",
        "Is fire cold?",
        "Is the earth flat?",
        "Is 2 + 2 equal to 4?",
        "Is the moon made of cheese?"
    )

    // Define the correct answers
    val correctAnswers = listOf(true, true, false, false, true, false)

    // State to track the current question index, score, and user answers
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    val userAnswers = remember { mutableStateListOf<Boolean?>() } // Store user answers

    // Check if we have reached the end of the questions
    val isLastQuestion = currentQuestionIndex >= questions.size - 1

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display the current question number
        Text(
            text = "Question ${currentQuestionIndex + 1}", // Increment question number
            style = TextStyle(
                color = Color.White,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(0f, 0f),
                    blurRadius = 10f
                )
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(70.dp))

        if (!isLastQuestion) {
            Text(
                text = questions[currentQuestionIndex],
                color = Color.Black,
                fontSize = 20.sp
            ) // Display the current question
            Spacer(modifier = Modifier.height(16.dp))

            // True button
            Button(onClick = {
                userAnswers.add(true) // Store the user's answer
                score += 1 // Increment score for correct answer (assumed true for simplicity)
                currentQuestionIndex += 1 // Move to the next question
            },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00A89A))
            ) {
                Text(text = "True", color = Color.White)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // False button
            Button(onClick = {
                userAnswers.add(false) // Store the user's answer
                currentQuestionIndex += 1 // Move to the next question
            },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9D56FF))
            ) {
                Text(text = "False", color = Color.White) // Corrected button text
            }
        } else {
            // Only show the score button after the last question
            Button(onClick = {
                // Pass userName and userAnswers as a comma-separated string
                navController.navigate("score_screen/$score/$userName/${userAnswers.joinToString(",")}")
            },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A275D))
            ) {
                Text(text = "View Score", color = Color.White)
            }
        }
    }
}




