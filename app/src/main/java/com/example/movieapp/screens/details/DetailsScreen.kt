package com.example.movieapp.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, movieData: String?) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            Text(text = movieData.toString(), style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.height(23.dp))
            // Button to take us to home screen
            Button(onClick = {
                // This is why we pass the nav controller all along!
                // That's the beauty, of the backstack!
                // We just have to pop this activity to go back to the previous
                // screen.
                navController.popBackStack()
            }) {
                Text(text = "Go Back")
            }
        }
    }

}