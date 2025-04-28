package com.example.flashcard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ScoreScreen(navController: NavController, score: Int, userName: String, userAnswers: List<Boolean>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display the score
        Text(text = "$userName's final score is: $score/6")
        Spacer(modifier = Modifier.height(16.dp))

        // Button to navigate to the Review Screen
        Button(onClick = {
            // Pass userName and userAnswers as a comma-separated string
            navController.navigate("review_screen/$userName/${userAnswers.joinToString(",")}")
        }) {
            Text(text = "Review Answers")
        }
    }
}


