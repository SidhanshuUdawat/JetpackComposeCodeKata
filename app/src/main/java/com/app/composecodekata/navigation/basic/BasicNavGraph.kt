package com.app.composecodekata.navigation.basic

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "" // Choose the start destination here
    ) {
        // Make use of composable to define the route

    }
}