package com.example.movieapp.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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