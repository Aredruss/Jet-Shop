package com.aredruss.jet_shop.domain

import com.aredruss.jet_shop.data.model.Product
import com.aredruss.jet_shop.domain.api.ProductApi

class ProductRepository(
    private val api: ProductApi
) {
    suspend fun getAllCategories(): Result<List<String>> {
        return runCatching {
            val response = api.getCategories()
            response ?:  throw Exception("Error getting categories")
        }.onSuccess { result ->
            Result.success(result)
        }.onFailure { error ->
            Result.failure<Throwable>(error)
        }
    }

    suspend fun getProductsForCategory(category: String): Result<List<Product>> {
        return runCatching {
            val response = api.getProductsInCategory(category)
            response ?:  throw Exception("Error getting products in category $category")
        }.onSuccess { result ->
            Result.success(result)
        }.onFailure { error ->
            Result.failure<Throwable>(error)
        }
    }

    suspend fun getProduct(productId: Int): Result<Product> {
        return runCatching {
            api.getProduct(productId) ?: throw Exception("Error getting product $productId")
        }.onSuccess { result ->
            Result.success(result)
        }.onFailure { error ->
            Result.failure<Throwable>(error)
        }
    }
}
