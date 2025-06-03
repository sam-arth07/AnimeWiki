package com.example.animewiki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animewiki.navigation.SetupNavigation
import com.example.animewiki.ui.theme.AnimeWikiTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeWikiTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}

