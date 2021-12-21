package com.example.movieapp.screens.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, movieData: String?) {
    // for now just use text
    Text(text = movieData.toString())
}