package com.aredruss.jet_shop.domain

import com.aredruss.jet_shop.data.model.Product
import com.aredruss.jet_shop.domain.api.ProductApi
import timber.log.Timber

class ProductRepository(
    private val api: ProductApi
) {
    suspend fun getAllCategories(): Result<List<String>> {
        return runCatching {
            api.getCategories()
        }.onFailure {
            Timber.e("$it: Error getting categories")
        }
    }

    suspend fun getProductsForCategory(category: String): Result<List<Product>> {
        return runCatching {
            api.getProductsInCategory(category)
        }.onFailure {
            Timber.e("$it: Error getting products in $category")
        }
    }

    suspend fun getProduct(productId: Int): Result<Product> {
        return runCatching {
            api.getProduct(productId)
        }.onFailure {
            Timber.e("$it: Error getting product #$productId")
        }
    }
}
