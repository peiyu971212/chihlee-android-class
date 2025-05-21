package com.example.api

data class PostsBody(
    val title: String? = null,
    val body: String? = null,
    val userId: Int? = null,
    val id: Int? = null
)
