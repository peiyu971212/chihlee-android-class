package com.example.shopdemoapp.api

import com.example.shopdemoapp.data.ProductDetailResponse
import com.example.shopdemoapp.data.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("/product_list")
    fun getProductListResponse(): Call<ProductsResponse>

    @GET("product/detail/{position}")
    fun getProductDetail(@Path("position") position: Int): Call<ProductDetailResponse>

}