package com.app.composecodekata.navigation.arguments

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail : Screen(route = "detail_screen/id={id}?name={name}") {
        fun routeTo(
            id: Int,
            name: String? = null
        ) = "detail_screen/id=$id?name=$name"
    }
}
