package com.aredruss.jet_shop.ui.category

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aredruss.jet_shop.ui.common.ErrorCard
import com.aredruss.jet_shop.ui.common.Loader
import com.aredruss.jet_shop.ui.theme.JetShopTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun CategoryScreen() {
    val categoryViewModel = getViewModel<CategoryViewModel>()
    val categoryState: CategoryState by categoryViewModel.categoryState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                CategoryTopCard(title = "Electronics")
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
                        Text(text = categoryState.products.toString())
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetShopTheme {
        CategoryScreen()
    }
}