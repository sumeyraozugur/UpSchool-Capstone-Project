package com.sum.capstoneproject.retrofit

import com.sum.capstoneproject.model.ProductModel
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {


    @GET("get_products.php")
    fun allProduct(): Call<List<ProductModel>>


    @GET("get_sale_products.php")
    fun bestSellers(): Call<List<ProductModel>>


}