package com.app.composecodekata.migration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import com.app.composecodekata.R

class MigrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.migration_activity_sol)
        val composeView = findViewById<ComposeView>(R.id.compose_view)
        composeView.setContent {
            CreateTextViews()
        }
    }
}