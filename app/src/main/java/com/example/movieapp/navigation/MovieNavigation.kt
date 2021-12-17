package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.screens.MovieScreens
import com.example.movieapp.screens.home.HomeScreen
import com.example.movieapp.screens.details.DetailsScreen


@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    // This is where we can put all of our nodes.
    // All of our composables/screens
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
        // This is where we build the nav graph
        composable(MovieScreens.HomeScreen.name) {
            // here we pass where this should lead us to.
            HomeScreen(navController = navController)
        }

        composable(MovieScreens.DetailScreen.name) {
            // Here we can go to DetailScreen for example
            DetailsScreen(navController = navController)
        }
    }
}