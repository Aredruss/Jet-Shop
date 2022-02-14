package com.aredruss.jet_shop.domain.api

import com.aredruss.jet_shop.data.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {

    @GET("/products/categories")
    suspend fun getCategories(): List<String>

    @GET("/products/category/{category}")
    suspend fun getProductsInCategory(@Path("category") category: String): List<Product>

    @GET("/products/{productId}")
    suspend fun getProduct(@Path("productId") productId: String): Product

    companion object {
        const val BASE_URL = "https://fakestoreapi.com/"
    }
}