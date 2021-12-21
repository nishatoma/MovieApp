package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.MovieScreens
import com.example.movieapp.screens.details.DetailsScreen
import com.example.movieapp.screens.home.HomeScreen


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

        // This is basically routing  to the activity we want
        // Now we will pass some data
        // with appending the name {movie}!!
        composable(MovieScreens.DetailScreen.name+"/{movie}",
        arguments = listOf(navArgument(name = "movie") {type = NavType.StringType})) {
            backStackEntry ->
            // Here we can go to DetailScreen for example
            // Now add the arguments string to the DetailsScreen too
            DetailsScreen(navController = navController,
            backStackEntry.arguments?.getString("movie"))
        }
    }
}