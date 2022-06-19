package com.sum.capstoneproject.retrofit

import com.sum.capstoneproject.response.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {


    @GET("/get_products.php")
    fun allProduct(): Call<ProductsResponse>


    @GET("/get_sale_products.php")
    fun bestSellers(): Call<ProductsResponse>



}