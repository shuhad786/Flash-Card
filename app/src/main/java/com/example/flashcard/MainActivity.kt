package com.example.flashcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.flashcard.ui.theme.FlashCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlashCardTheme {
                val navController = rememberNavController()
                val correctAnswers = listOf(true, true, false, false, true, false) // Define correct answers

                NavHost(navController = navController, startDestination = Routes.Home, builder = {
                    composable(Routes.Home) {
                        Home(navController)
                    }
                    composable("question_screen/{userName}") { backStackEntry ->
                        val userName = backStackEntry.arguments?.getString("userName") ?: ""
                        QuestionScreen(navController, userName)
                    }
                    composable("score_screen/{score}/{userName}/{userAnswers}") { backStackEntry ->
                        val score = backStackEntry.arguments?.getString("score")?.toInt() ?: 0
                        val userName = backStackEntry.arguments?.getString("userName") ?: ""
                        val userAnswersString = backStackEntry.arguments?.getString("userAnswers") ?: ""
                        val userAnswers = userAnswersString.split(",").map { it.toBoolean() } // Convert string back to Boolean list
                        ScoreScreen(navController, score, userName, userAnswers) // Pass userAnswers
                    }
                    composable("review_screen/{userName}/{userAnswers}") { backStackEntry ->
                        val userName = backStackEntry.arguments?.getString("userName") ?: ""
                        val userAnswersString = backStackEntry.arguments?.getString("userAnswers") ?: ""
                        val userAnswers = userAnswersString.split(",").map { it.toBoolean() } // Convert string back to Boolean list
                        ReviewScreen(navController, userName, userAnswers, correctAnswers) // Pass correctAnswers
                    }

                })
            }
        }
    }
}

