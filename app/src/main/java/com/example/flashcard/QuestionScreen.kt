package com.example.flashcard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    val isLastQuestion = currentQuestionIndex >= questions.size

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (!isLastQuestion) {
            Text(text = questions[currentQuestionIndex])
            Spacer(modifier = Modifier.height(16.dp))

            // True button
            Button(onClick = {
                userAnswers.add(true) // Store the user's answer
                score += 1 // Increment score for correct answer (assumed true for simplicity)
                currentQuestionIndex += 1 // Move to the next question
            }) {
                Text(text = "True")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // False button
            Button(onClick = {
                userAnswers.add(false) // Store the user's answer
                currentQuestionIndex += 1 // Move to the next question
            }) {
                Text(text = "False")
            }
        } else {
            // Only show the score button after the last question
            Button(onClick = {
                // Pass userName and userAnswers as a comma-separated string
                navController.navigate("score_screen/$score/$userName/${userAnswers.joinToString(",")}")
            }) {
                Text(text = "View Score")
            }
        }
    }
}


