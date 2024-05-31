package com.example.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostsApi {
    @GET("/posts")
    fun getPosts(): Call<List<Posts>>

    @POST("/posts")
    fun postPosts(@Body body: PostsBody): Call<Posts>
}