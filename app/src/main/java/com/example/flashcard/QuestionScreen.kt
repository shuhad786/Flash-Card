package com.example.flashcard

import androidx.compose.foundation.background
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
import android.util.Log

@Composable
fun QuestionScreen(navController: NavController, userName: String) {
    // Define the questions
    val questions = listOf(
        "The sum of the angles in a triangle is always 180 degrees",
        "The Declaration of Independence was signed in 1776",
        "'Moby Dick' was written by Mark Twain",
        "Mount Everest is the tallest mountain in the world",
        "DNA stands for Deoxyribonucleic Acid",
        "Humans have 4 lungs"
    )

    // Define the correct answers
    val correctAnswers = listOf(true, true, false, true, true, false)

    // State to track the current question index, score, and user answers
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    val userAnswers = remember { mutableStateListOf<Boolean?>() } // Store user answers

    // Check if we have reached the end of the questions
    val isLastQuestion = currentQuestionIndex >= questions.size - 1

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display the current question number
        Text(
            text = if (isLastQuestion) "Completed" else "Question ${currentQuestionIndex + 1}",
            style = TextStyle(
                color = Color.Black,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                shadow = Shadow(
                    color = Color(0xFFFF49D6),
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
                color = Color.White,
                fontSize = 20.sp
            ) // Display the current question
            Spacer(modifier = Modifier.height(16.dp))

            // True button
            Button(onClick = {
                userAnswers.add(true) // Store the user's answer
                Log.d("QuizApp", "Question ${currentQuestionIndex + 1}: User answered True") // Log the answer
                if (correctAnswers[currentQuestionIndex]) score += 1 // Increment score if correct
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
                Log.d("QuizApp", "Question ${currentQuestionIndex + 1}: User answered False") // Log the answer
                if (!correctAnswers[currentQuestionIndex]) score += 1 // Increment score if correct
                currentQuestionIndex += 1 // Move to the next question
            },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9D56FF))
            ) {
                Text(text = "False", color = Color.White) // Corrected button text
            }
        } else {
            // Only show the score button after the last question
            Text(
                text = questions[currentQuestionIndex], // Display the last question
                color = Color.White,
                fontSize = 20.sp
            ) // Display the current question
            Spacer(modifier = Modifier.height(16.dp))

            // Last question buttons
            Button(onClick = {
                userAnswers.add(true) // Assume user answered True for the last question
                Log.d("QuizApp", "Question ${currentQuestionIndex + 1}: User answered True") // Log the answer
                if (correctAnswers[currentQuestionIndex]) score += 1 // Increment score if correct
                navController.navigate("score_screen/$score/$userName/${userAnswers.joinToString(",")}")
            },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00A89A))
            ) {
                Text(text = "True", color = Color.White)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                userAnswers.add(false) // Assume user answered False for the last question
                Log.d("QuizApp", "Question ${currentQuestionIndex + 1}: User answered False") // Log the answer
                if (!correctAnswers[currentQuestionIndex]) score += 1 // Increment score if correct
                navController.navigate("score_screen/$score/$userName/${userAnswers.joinToString(",")}")
            },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9D56FF))
            ) {
                Text(text = "False", color = Color.White) // Corrected button text
            }
        }
    }
}







