package com.example.guessthenumber

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GuessScreen() {

    val tfGuess = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Kalan Hak : 5", fontSize = 36.sp, color = Color.Red)
        Text(text = "Yardım : Arttır", fontSize = 25.sp)

        TextField(
            value = tfGuess.value,
            onValueChange = { tfGuess.value = it },
            label = { Text(text = "Tahmin") }
        )

        Button(
            onClick = {

            },
            modifier = Modifier.size(250.dp, 50.dp),
        ) {
            Text(text = "TAHMİN ET")
        }
    }
}