package com.aredruss.jet_shop.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aredruss.jet_shop.ui.category.CategoryScreen
import com.aredruss.jet_shop.ui.home.HomeScreen
import com.aredruss.jet_shop.ui.theme.JetShopTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetShopTheme {
                Host()
            }
        }
    }
}

@Composable
fun Host() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomeScreen(navController = navController)
        }
        composable(route = "category/{name}") { navBackStackEntry ->
            CategoryScreen(
                navController = navController,
                category = navBackStackEntry.arguments?.getString("name") ?: "electronics"
            )
        }
    }
}

