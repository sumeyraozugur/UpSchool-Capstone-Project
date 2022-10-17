package com.sum.capstoneproject.retrofit

import com.sum.capstoneproject.model.ProductModel
import com.sum.capstoneproject.response.CRUDResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductApi {

    @GET("get_products.php")
    fun allProduct(): Call<List<ProductModel>>

    @GET("get_categories.php")
    fun getCategories(): Call<List<String>>

    @POST("add_to_bag.php")
    @FormUrlEncoded
    fun addToBag(
        @Field("user") user: String,
        @Field("title") title: String,
        @Field(" price") price: Double,
        @Field("description") description: String,
        @Field(" category") category: String,
        @Field("image") image: String,
        @Field(" rate") rate: Double,
        @Field(" count") count: Int,
        @Field(" sale_state") sale_state: Int,
    ): Call<CRUDResponse>



    @POST("get_bag_products_by_user.php")
    @FormUrlEncoded
    fun getBagProducts(
        @Field("user") user: String
    ):Call<List<ProductModel>>


    @POST("delete_from_bag.php")
    @FormUrlEncoded
    fun deleteFromBag(
            @Field("id")
            id: Int
    ): Call<CRUDResponse>




}

























