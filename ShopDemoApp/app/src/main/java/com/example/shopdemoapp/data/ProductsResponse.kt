package com.example.shopdemoapp.data

data class ProductsResponse(
    val status: Int,
    val message: String,
    val data: List<Product>
)

data class Product(
    val id: Int,
    val productName: String,
    val price: Int,
    val image: String,
)