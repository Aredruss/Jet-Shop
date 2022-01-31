package com.aredruss.jet_shop.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aredruss.jet_shop.ui.home.HomeScreen
import com.aredruss.jet_shop.ui.home.HomeViewModel
import com.aredruss.jet_shop.ui.theme.JetShopTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetShopTheme {
                HomeScreen(homeViewModel)
            }
        }
    }
}
