package com.aredruss.jet_shop.ui.product

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(productId: String) {
    val productViewModel = getViewModel<ProductViewModel> { parametersOf(productId) }
    val productState by productViewModel.productState.collectAsState()

    Scaffold(
        topBar = {

        }, content = {
            Text(text = productState.product.toString())
        })

}