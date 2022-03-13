package com.aredruss.jet_shop.di

import com.aredruss.jet_shop.domain.ProductRepository
import com.aredruss.jet_shop.domain.ShopPreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val domainModule = module {
    single { ShopPreferences(appContext = androidApplication()) }
    single { ProductRepository(api = get()) }
}