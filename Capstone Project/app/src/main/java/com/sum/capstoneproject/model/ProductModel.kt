package com.sum.capstoneproject.model

import com.google.gson.annotations.SerializedName

data class ProductModel(
    @SerializedName("id")
    var productId: Int? = 0,

    @SerializedName("user")
    var productUser:String?,

    @SerializedName("title")
    var productTitle:String?,

    @SerializedName("price")
    var productPrice: String?,

    @SerializedName("description")
    var productDescription:String?,

    @SerializedName("category")
    var productCategory:String?,

    @SerializedName("image")
    var productImageUrl: String?,

    @SerializedName("rate")
    var productRate: String?,

    @SerializedName("count")
    var productCount:String?



)
