package com.app.composecodekata.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.composecodekata.navigation.basic.SetupNavGraph


import com.app.composecodekata.ui.theme.JetpackComposeCodeKataAS24Theme

class NavigationActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCodeKataAS24Theme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}
