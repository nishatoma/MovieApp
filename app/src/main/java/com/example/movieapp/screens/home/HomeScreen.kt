package com.example.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.components.MovieRow;
import com.example.movieapp.components.MovieAppTopBar
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.screens.MovieScreens

// Remember this composable is called
// within the MovieNavigation class.
@Composable
fun HomeScreen(navController: NavController) {
    // Scaffold
    MovieAppTopBar(padding = 5.dp) {
        MainContent(navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    // Create a structure that will allow us to create
    // a list of movies
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn() {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    Log.d("MainActivity", "MainContent: $movie ")
                    // We can actually use navController now to access
                    // the details screen!!
                    // Now we have to pass the actual data
                    navController.navigate(MovieScreens.DetailScreen.name + "/${movie}")
                }
            }
        }
    }
}