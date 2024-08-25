package com.example.unit1_composetutorial_composebasicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unit1_composetutorial_composebasicscodelab.ui.theme.Unit1ComposeTutorialComposeBasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Unit1ComposeTutorialComposeBasicsCodelabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    Box (
                        modifier = Modifier
                            .padding(padding)
                    ) {
                        composeQuadrant()
                    }
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
fun taskCompletion(modifier: Modifier = Modifier) {
    val completeImage = painterResource(R.drawable.ic_task_completed)
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = completeImage, contentDescription = "Checkmark")
        Text(
            text = "All tasks completed",
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(
                    top = 24.dp,
                    bottom = 8.dp
                )
        )
        Text(
            text = "Nice Work!",
            fontSize = 16.sp
        )
    }
}

@Composable
fun composeQuadrant(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier.weight(1f)
        ) {
            quadrant(
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFEADDFF)),
                titleText = stringResource(R.string.quad1_title),
                description = stringResource(R.string.quad1_description)
            )
            quadrant(
                modifier = modifier
                    .weight(weight = 1f)
                    .background(color = Color(0xFFD0BCFF)),
                titleText = stringResource(R.string.quad2_title),
                description = stringResource(R.string.quad2_description)
            )
        }
        Row(
            modifier = modifier.weight(1f)
        ) {
            quadrant(
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFB69DF8)),
                titleText = stringResource(R.string.quad3_title),
                description = stringResource(R.string.quad3_description)
            )
            quadrant(
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFF6EDFF)),
                titleText = stringResource(R.string.quad4_title),
                description = stringResource(R.string.quad4_description)
            )
        }
    }
}

@Composable
fun quadrant(modifier: Modifier = Modifier, titleText: String, description: String) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = titleText,
            modifier = Modifier
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun quadrantPreview() {
    Unit1ComposeTutorialComposeBasicsCodelabTheme {
        composeQuadrant()
    }
}

@Preview(showBackground = true)
@Composable
fun LearningPreview() {
    Unit1ComposeTutorialComposeBasicsCodelabTheme {
        LearningWindow()
    }
}

@Preview(showBackground = true)
@Composable
fun taskPreview() {
    Unit1ComposeTutorialComposeBasicsCodelabTheme {
        taskCompletion()
    }
}