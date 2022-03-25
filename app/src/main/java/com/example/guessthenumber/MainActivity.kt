package com.example.guessthenumber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.guessthenumber.ui.theme.GuessTheNumberTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessTheNumberTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PagePass()
                }
            }
        }
    }
}

@Composable
fun PagePass() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homepage") {
        composable("homepage") {
            HomePage(navController = navController)
        }
        composable("guess_screen") {
            GuessScreen(navController = navController)
        }
        composable("result_screen/{result}", arguments = listOf(
            navArgument("result") { type = NavType.BoolType }
        )) {
            val result = it.arguments?.getBoolean("result")!!
            ResultScreen(result = result)
        }
    }
}

@Composable
fun HomePage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tahmin Oyunu", fontSize = 40.sp)
        Image(
            painter = painterResource(id = R.drawable.zar_resim),
            contentDescription = ""
        )
        Button(
            onClick = {
                navController.navigate("guess_screen")
            },
            modifier = Modifier.size(250.dp, 50.dp),
        ) {
            Text(text = "OYUNA BAŞLA")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GuessTheNumberTheme {

    }
}