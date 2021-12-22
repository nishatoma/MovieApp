package com.example.movieapp.screens.details

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.movieapp.components.MovieAppTopBar
import com.example.movieapp.components.MovieRow
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies

@ExperimentalAnimationApi
@Composable
fun DetailsScreen(navController: NavController, movieData: String?) {

    // adding the top bar and the back navigation
    MovieAppTopBar(
        padding = 5.dp, topBarText = "Movie Details",
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back",
                Modifier.clickable {
                    navController.popBackStack()
                }
            )
        })
    {
        MainContent(navController = navController, movieData = movieData)
    }

}

@ExperimentalAnimationApi
@Composable
fun MainContent(navController: NavController, movieData: String?) {
    val movie: Movie = getMovies().single { movie ->
        movieData == movie.id
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Add the movie row here
            MovieRow(movie = movie)
            Spacer(modifier = Modifier.padding(8.dp))
            Divider()
            Text(text = "Movie Images", modifier = Modifier.padding(5.dp))
            HorizontalScrollableImageView(movie)
        }
    }
}

@Composable
private fun HorizontalScrollableImageView(movie: Movie) {
    LazyRow {
        items(movie.images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                Image(
                    painter = rememberImagePainter(data = image),
                    contentDescription = "Movie image"
                )
            }
        }
    }
}