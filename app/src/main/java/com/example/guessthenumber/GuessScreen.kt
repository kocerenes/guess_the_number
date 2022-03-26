package com.example.guessthenumber

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

@Composable
fun GuessScreen(navController: NavController) {

    val tfGuess = remember { mutableStateOf("") }
    val randomNumber = remember { mutableStateOf(0) }
    val remainingRight = remember { mutableStateOf(5) }
    val orientation = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //sayfa açıldığı anda çalışan metod
        LaunchedEffect(key1 = true){
            randomNumber.value = Random.nextInt(101)
            Log.e("rastgelesayi",randomNumber.value.toString())
        }

        Text(text = "Kalan Hak : ${remainingRight.value}", fontSize = 36.sp, color = Color.Red)
        Text(text = "Yardım : ${orientation.value}", fontSize = 25.sp)

        TextField(
            value = tfGuess.value,
            onValueChange = { tfGuess.value = it },
            label = { Text(text = "Tahmin") }
        )

        Button(
            onClick = {
                remainingRight.value--
                val guess = tfGuess.value.toInt()

                if (guess == randomNumber.value){
                    navController.navigate("result_screen/true") {
                        popUpTo("guess_screen") { inclusive = true }
                    }
                    return@Button
                }
                if (guess > randomNumber.value){
                    orientation.value = "azalt"
                }
                if (guess < randomNumber.value){
                    orientation.value = "arttır"
                }
                if (remainingRight.value == 0){
                    navController.navigate("result_screen/false") {
                        popUpTo("guess_screen") { inclusive = true }
                    }

                }
                tfGuess.value = ""
            },
            modifier = Modifier.size(250.dp, 50.dp),
        ) {
            Text(text = "TAHMİN ET")
        }
    }
}