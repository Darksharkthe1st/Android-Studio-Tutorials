package com.example.androidstudiounit1_learntogetherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidstudiounit1_learntogetherapp.ui.theme.AndroidStudioUnit1LearnTogetherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidStudioUnit1LearnTogetherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LearningWindow(modifier: Modifier = Modifier) {
    val myImage = painterResource(R.drawable.bg_compose_background)
    Column(modifier = modifier) {
        Image(
            painter = myImage,
            contentDescription = "Background Image with App Dev Icons"
        )

        //Text #1
        Text(
            text = stringResource(R.string.Title_Line),
            fontSize = 24.sp,
            modifier = modifier
                .padding(16.dp)
        )
        //Text #2
        Text(
            text = stringResource(R.string.description_line_1),
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify,
        )

        //Text #3
        Text(
            text = stringResource(R.string.description_line_2),
            modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun LearningPreview() {
    AndroidStudioUnit1LearnTogetherAppTheme {
        LearningWindow()
    }
}