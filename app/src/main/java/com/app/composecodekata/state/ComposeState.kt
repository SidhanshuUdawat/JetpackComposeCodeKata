package com.app.composecodekata.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


import com.app.composecodekata.ui.theme.JetpackComposeCodeKataAS24Theme

class HelloViewModel : ViewModel() {
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    fun onNameChanged(newName: String) {
        _name.value = newName
    }
}


class ComposeState {

    @Composable
    fun HelloScreen(
        helloViewModel: HelloViewModel = viewModel()
    ) {
        val name by helloViewModel.name.observeAsState("")
        HelloContent(name, onNameChanged = helloViewModel::onNameChanged)
    }

    @Composable
    fun HelloContent(name: String, onNameChanged: (String) -> Unit) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Hello, $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
            OutlinedTextField(
                value = "",
                onValueChange = onNameChanged,
                label = { Text("Name") }
            )

        }
    }

    @Preview(showBackground = true, widthDp = 320)
    @Composable
    fun DefaultPreview() {
        JetpackComposeCodeKataAS24Theme {
            HelloContent("Sid") { }
        }
    }
}