package com.example.shopdemoapp.data

data class ProductDetailResponse(
    val status: Int,
    val message: String,
    val data: ProductDetail
)

data class ProductDetail(
    val id: Int,
    val title: String,
    val price: Int,
    val description: String,
    val category: String,
    val image: String
)
