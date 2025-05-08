package com.tu.kohalal.ui.theme.Shared.Navgat

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tu.kohalal.ui.theme.Shared.Scene.HomeScreen

sealed class Screen(val route: String) {
    object Home : Screen("homeScreen")
    object Mosque : Screen("mosqueScreen")
    object Shop : Screen("shopScreen")
    object Add : Screen("addScreen")
}

@Composable
fun Navigate(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
//        composable(Screen.Mosque.route) { MosqueScreen() }
//        composable(Screen.Shop.route) { ShopScreen() }
//        composable(Screen.Add.route) { AddProductScreen() }
    }
}
