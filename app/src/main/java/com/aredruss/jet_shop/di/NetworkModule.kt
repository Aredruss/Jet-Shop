package com.aredruss.jet_shop.di

import com.aredruss.jet_shop.domain.api.ProductApi
import com.squareup.moshi.Moshi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single<ProductApi> {
        val moshi = Moshi.Builder().build()
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(ProductApi.BASE_URL)
            .build()
            .create(ProductApi::class.java)
    }
}