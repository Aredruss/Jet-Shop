package com.aredruss.jet_shop

import android.app.Application
import com.aredruss.jet_shop.di.domainModule
import com.aredruss.jet_shop.di.networkModule
import com.aredruss.jet_shop.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(networkModule, domainModule, uiModule)
        }
    }
}