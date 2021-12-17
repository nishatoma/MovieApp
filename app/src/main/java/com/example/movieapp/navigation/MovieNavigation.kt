package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.screens.MovieScreens


@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
        // This is where we build the nav graph
        composable(MovieScreens.HomeScreen.name) {
            // here we pass where this should lead us to.
//            HomeScreen()
        }
    }
}