package com.example.ch9_api_okhttp

data class PostResponse(
    val userId: Int,
    val id: Int,
    val title: String? = null,  // 允許為空，並給予預設值 null
    val body: String? = null    // 允許為空，並給予預設值 null
)
