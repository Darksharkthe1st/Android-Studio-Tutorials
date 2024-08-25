package com.example.unit2_lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unit2_lemonadeapp.ui.theme.Unit2LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Unit2LemonadeAppTheme {
                lemonade()
            }
        }
    }
}

@Composable
fun lemonade(modifier: Modifier = Modifier
    .fillMaxSize()
) {
    var step by remember { mutableStateOf(1) }
    Column(
        modifier = modifier
    ) {
        Column(modifier = modifier
            .weight(weight = 0.3f)
            .background(color = Color(255, 227, 75))
        )
        {
            Spacer(modifier = Modifier
                .height(40.dp))

            Text(
                text = "Lemonade",
                modifier = Modifier
                    .fillMaxSize(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
        Column(modifier = modifier
            .weight(3f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val image = when (step) {
                1 -> R.drawable.lemon_tree
                2 -> R.drawable.lemon_squeeze
                3 -> R.drawable.lemon_drink
                4 -> R.drawable.lemon_restart
                else -> R.drawable.lemon_squeeze
            }

            val description = when (step) {
                1 -> R.string.description_1
                2 -> R.string.description_2
                3 -> R.string.description_3
                4 -> R.string.description_4
                else -> R.string.description_2
            }

            val content_desc = when (step) {
                1 -> R.string.description_1
                2 -> R.string.content_des_2
                3 -> R.string.content_des_3
                4 -> R.string.content_des_4
                else -> R.string.content_des_2
            }

            Button(onClick = {
                if (step == 1) {
                    step = 2
                } else if (step == 2) {
                    step = 10
                } else if (step >= 10 && step <= 15) {
                    step++
                } else if (step >= 15) {
                    step = 3
                } else if (step == 3) {
                    step = 4
                } else {
                    step = 1
                }

            }) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = stringResource(id = content_desc)
                )
            }

            Text(
                text = stringResource(id = description) + "1"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun lemonadeApp() {
    Unit2LemonadeAppTheme {
        lemonade()
    }
}