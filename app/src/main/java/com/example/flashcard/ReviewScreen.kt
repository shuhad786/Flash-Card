package com.example.flashcard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ReviewScreen(navController: NavController, userName: String, userAnswers: List<Boolean>, correctAnswers: List<Boolean>) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "$userName's Review", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // Display each question and the user's answer
        val questions = listOf(
            "Is the sky blue?",
            "Is water wet?",
            "Is fire cold?",
            "Is the earth flat?",
            "Is 2 + 2 equal to 4?",
            "Is the moon made of cheese?"
        )

        for (index in userAnswers.indices) {
            val questionText = questions[index]
            val userAnswer = userAnswers[index]
            val correctAnswer = correctAnswers[index]

            // Highlight the answer
            Text(
                text = "$questionText - Your answer: ${if (userAnswer == true) "True" else "False"}",
                color = if (userAnswer == correctAnswer) Color.Green else Color.Red
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Button to navigate back to Home
        Button(onClick = {
            navController.navigate(Routes.Home)
        }) {
            Text(text = "Exit")
        }
    }
}
