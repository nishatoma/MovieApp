package com.example.movieapp.screens

import java.lang.IllegalArgumentException

// List Out all possible screens
enum class MovieScreens {
    HomeScreen,
    DetailScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailScreen.name -> DetailScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route not recognized.")
        }
    }
}