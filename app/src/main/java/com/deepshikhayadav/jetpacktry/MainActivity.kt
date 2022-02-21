package com.deepshikhayadav.jetpacktry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshikhayadav.jetpacktry.ui.theme.JetpackTryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTryTheme {
                // A surface container using the 'background' color from the theme

                   myApp()

            }
        }
    }
}

@Composable
private fun myApp(names: List<String> =listOf("Jetpack","Compose")){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ){
        Column(modifier = Modifier.padding(vertical = 4.dp)) {
            for (name in names){
                Greeting(name = name)
            }
        }
    }

}
@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(color = MaterialTheme.colors.primary,
    modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)) {
        Row(modifier = Modifier.padding(10.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
                .fillMaxWidth()) {
                Text (text = "Hello ,", modifier = Modifier.padding(10.dp))
                Text (text = " $name", modifier = Modifier.padding(10.dp))

            }
            OutlinedButton(onClick = { expanded.value=!expanded.value},Modifier.padding(10.dp)) {
                Text(if(expanded.value) "Show less" else "Show more")
            }
        }


    }
}

@Preview(showBackground = true, name="Text Preview", widthDp = 320)
@Composable
fun DefaultPreview() {
    JetpackTryTheme {
        myApp()
    }
}