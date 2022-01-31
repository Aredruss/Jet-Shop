package com.aredruss.jet_shop.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Ranking
)

@JsonClass(generateAdapter = true)
data class Ranking(
    val rate: Double,
    val count: Int
)
