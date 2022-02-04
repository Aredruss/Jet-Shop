package com.aredruss.jet_shop.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.aredruss.jet_shop.ui.common.ErrorCard
import com.aredruss.jet_shop.ui.common.Loader
import com.aredruss.jet_shop.ui.theme.JetShopTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val homeViewModel = getViewModel<HomeViewModel>()
    val homeState: HomeState by homeViewModel.homeState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                GreetingTopCard()
            },
            content = {
                when {
                    homeState.loading -> Loader()
                    homeState.error -> {
                        ErrorCard(
                            error = homeState.message ?: "Something went wrong",
                            action = homeViewModel::getCategories
                        )
                    }
                    else -> CategoryList(list = homeState.categories) {
                        navController.navigate("category/$it")
                    }
                }
            },
            bottomBar = {
                BottomLabel()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetShopTheme {
        CategoryItem(title = "Electronics"){}
    }
}
