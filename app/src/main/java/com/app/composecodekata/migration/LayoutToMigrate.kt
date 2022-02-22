package com.app.composecodekata.migration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.composecodekata.ui.theme.JetpackComposeCodeKataAS24Theme

@Composable
fun CreateTextViews() {
    val list = mutableListOf("TextView 1", "TextView 2", "TextView 3")
    Column(modifier = Modifier.fillMaxWidth()) {
        list.forEach {
            Text(
                text = it,
                style = MaterialTheme.typography.h4
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun OnboadingPreview() {
    JetpackComposeCodeKataAS24Theme {
        CreateTextViews()
    }
}