package com.app.composecodekata.navigation.basic

/**
 * Define the screens here and their expected paths
 */
sealed class Screen {
    object Home : Screen()
    object Detail : Screen()
}
