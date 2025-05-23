package com.tu.kohalal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

import androidx.navigation.compose.rememberNavController
import com.tu.kohalal.ui.theme.KoHalalTheme
import com.tu.kohalal.ui.theme.Shared.Navgat.Navigate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoHalalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
//                    BakingScreen()
                    val navController = rememberNavController()
                    Navigate(navController)
                }
            }
        }
    }
}