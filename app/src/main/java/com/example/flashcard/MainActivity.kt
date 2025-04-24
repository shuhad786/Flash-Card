package com.example.flashcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.flashcard.ui.theme.FlashCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlashCardTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.Home, builder = {
                    composable(Routes.Home){
                        Home(navController)
                    }
                    composable(Routes.Question_screen){
                        QuestionScreen(navController)
                    }
                    composable(Routes.Score_screen){
                        ScoreScreen(navController)
                    }
                    composable(Routes.Review_screen){
                        ReviewScreen(navController)
                    }
                })
            }
        }
    }
}
