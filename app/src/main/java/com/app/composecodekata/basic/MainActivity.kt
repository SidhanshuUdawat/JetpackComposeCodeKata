package com.app.composecodekata.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.composecodekata.R
import com.app.composecodekata.ui.theme.JetpackComposeCodeKataAS24Theme


/**
 * State in an app is any value that can change over time.
 * This is a very broad definition and encompasses everything from a Room database to a variable on a class.
 *
 * Compose is declarative and as such the only way to update it is by calling the same composable with
 * new arguments.
 *
 * These arguments are representations of the UI state.
 * Any time a state is updated a recomposition takes place.
 * As a result, things like TextField don’t automatically update like they do in imperative XML based views.
 * A composable has to explicitly be told the new state in order for it to update accordingly.
 *
 * Ref: https://developer.android.com/jetpack/compose/state
 * Imp: https://developer.android.com/jetpack/compose/mental-model
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCodeKataAS24Theme {
                MyApp()
            }
        }
    }
}

// Problem 1: On boarding screen will never go away let's try to find a solution to fix it
// Hint: https://developer.android.com/jetpack/compose/state#state-in-composables

// Problem 2: Composables with internal state tend to be less reusable and harder to test.
// Hint 1: A stateless composable is a composable that doesn't hold any state. An easy way to achieve stateless is by using state hoisting.
// https://developer.android.com/jetpack/compose/state#state-hoisting

// Hint 2: create a separate composable function for on boarding screen which takes lambda as input

// Problem 3: On boarding screen shows again on the configuration change for example on screen rotation.
// How do we stop that?


@Composable
fun MyApp() {
    var shouldShowOnboarding = true

    if (shouldShowOnboarding) {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize()
                // Let's try to align the content in the Center
            ) {
                Text("Welcome to the Basics Codelab!")
                Button(
                    modifier = Modifier.padding(vertical = 24.dp),
                    onClick = { shouldShowOnboarding = false }
                ) {
                    Text("Continue")
                }
            }
        }
    } else {
        Greetings()
    }
}

// Problem - 1: Let's increase the List size to 1k and see what happens?
// Problem - 2: Use a replacement of RecyclerView with 3 lines of code, instead of multiple files ;)
@Composable
private fun Greetings(names: List<String> = List(2) { "$it" }) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        names.forEach {
            Greeting(name = it)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}


// Problem - 1: The expanded state is not behaving as expected let's find a solution
// Problem - 2: View isn't the whole width of the screen what modifier would you use?
// Problem - 3: Let's try to change the fontWeight for "MaterialTheme.typography.h4"

@Composable
private fun CardContent(name: String) {
    var expanded = false // Change here what you did earlier ;)

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name,
                style = MaterialTheme.typography.h4
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }

            )
        }
    }
}

@Preview
@Composable
fun OnboadingPreview() {
    JetpackComposeCodeKataAS24Theme {
        MyApp()
    }
}

// Make use of another @Preview tag to display the night mode version of the layout
// Set width to increase the size
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCodeKataAS24Theme {
        Greetings()
    }
}
