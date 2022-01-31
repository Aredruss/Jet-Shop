package com.aredruss.jet_shop.di

import com.aredruss.jet_shop.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        HomeViewModel(
            prefs = get(),
            productRepo = get()
        )
    }
}