package com.example.movieapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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

@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
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
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Movie Image"
                )
            }

            Text(text = movie.title)
        }

    }
}