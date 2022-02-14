package com.aredruss.jet_shop.ui.category

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.aredruss.jet_shop.helpers.safeNavigate
import com.aredruss.jet_shop.ui.common.ErrorCard
import com.aredruss.jet_shop.ui.common.Loader
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    navController: NavController,
    category: String
) {
    val categoryViewModel = getViewModel<CategoryViewModel> { parametersOf(category) }
    val categoryState: CategoryState by categoryViewModel.categoryState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                CategoryTopCard(title = category)
            },
            content = {
                when {
                    categoryState.loading -> Loader()
                    categoryState.error -> {
                        ErrorCard(
                            error = categoryState.message ?: "Something went wrong",
                            action = categoryViewModel::loadCategories
                        )
                    }
                    else -> {
                        ProductList(list = categoryState.products, action = { id ->
                            navController.safeNavigate("product/$id")
                        })
                    }
                }
            }
        )
    }
}