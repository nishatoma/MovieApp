package com.example.movieapp.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.movieapp.model.Movie

@Composable
fun MovieAppTopBar(
    backGroundColor: Color = Color.White,
    elevation: Dp = 0.dp,
    padding: Dp = 0.dp,
    topBarText: String = "Movies",
    navigationIcon: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    // Scaffold
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = backGroundColor,
            elevation = elevation,
            modifier = Modifier.padding(padding)
        ) {
            if (navigationIcon != null) {
                navigationIcon()
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = topBarText)
        }
    }) {
        content()
    }
}

@ExperimentalAnimationApi
@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit = {}) {

    // Has our card down arrow "expand" icon been clicked?
    val expanded = remember {
        mutableStateOf(false)
    }
    // Icon arrow up or down value
    val arrowDirection = remember {
        mutableStateOf(Icons.Filled.KeyboardArrowDown)
    }

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        elevation = 6.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 5.dp
            ) {
                // Bring images from URL
                Image(
                    painter = rememberImagePainter(
                        data = movie.images[0],
                        builder = {
                            crossfade(true)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = "Movie Poster",
                    modifier = Modifier.size(128.dp)
                )

            }

            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = "Released: ${movie.year}",
                    style = MaterialTheme.typography.caption
                )
                // The info that's gonna be hidden at first
                AnimatedVisibility(visible = expanded.value) {
                    Column {
                        Text(buildAnnotatedString {
                            // This allows us to actually change individual strings
                            // we want to show
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 13.sp
                                )
                            ) {
                                append("Plot: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(movie.plot)
                            }
                        }, modifier = Modifier.padding(6.dp))
                        Divider()
                        Text(
                            text = "Director: ${movie.director}",
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier.padding(6.dp)
                        )
                        Text(
                            text = "Actors: ${movie.actors}",
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier.padding(6.dp)
                        )
                        Text(
                            text = "Rating: ${movie.rating}",
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier.padding(6.dp)
                        )
                    }
                }

                // Expand card functionality
                Icon(
                    imageVector = arrowDirection.value,
                    contentDescription = "Down Arrow",

                    Modifier
                        .size(25.dp)
                        .clickable {
                            expanded.value = !expanded.value
                            if (expanded.value) {
                                arrowDirection.value = Icons.Filled.KeyboardArrowUp
                            } else {
                                arrowDirection.value = Icons.Filled.KeyboardArrowDown
                            }

                        },
                    tint = Color.DarkGray
                )
            }

        }

    }
}