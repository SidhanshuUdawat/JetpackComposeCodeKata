package com.app.composecodekata.navigation.arguments

/**
 * Problem: Detail Screen takes arguments and we need to extend the Detail object to make it more concrete
 */
sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail : Screen(route = "detail_screen/id={id}?name={name}")
}
