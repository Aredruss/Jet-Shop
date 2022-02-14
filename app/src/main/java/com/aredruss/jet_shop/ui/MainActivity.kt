package com.aredruss.jet_shop.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aredruss.jet_shop.domain.ShopPreferences
import com.aredruss.jet_shop.ui.category.CategoryScreen
import com.aredruss.jet_shop.ui.home.HomeScreen
import com.aredruss.jet_shop.ui.onboarding.OnBoardingScreen
import com.aredruss.jet_shop.ui.product.ProductScreen
import com.aredruss.jet_shop.ui.theme.JetShopTheme
import org.koin.androidx.compose.get

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetShopTheme {
                Host(finishAction = this::finish)
            }
        }
    }
}

@Composable
fun Host(
    prefs: ShopPreferences = get(),
    finishAction: () -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = if (prefs.onBoardingShown) {
            "home"
        } else {
            "onboarding"
        }
    ) {
        composable("onboarding") {
            OnBoardingScreen(navController = navController)
        }
        composable(route = "home") {
            HomeScreen(
                navController = navController,
                finishAction = finishAction
            )
        }
        composable(route = "category/{name}") { navBackStackEntry ->
            CategoryScreen(
                navController = navController,
                category = navBackStackEntry.arguments?.getString("name") ?: "electronics"
            )
        }
        composable(route = "product/{id}") { navBackStackEntry ->
            ProductScreen(
                productId = navBackStackEntry.arguments?.getString("id") ?: "1"
            )
        }
    }
}
