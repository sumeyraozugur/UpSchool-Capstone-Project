package com.sum.capstoneproject.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
    @SerializedName("id")
    var productId: Int? = 0,

    @SerializedName("user")
    var productUser: String?,

    @SerializedName("title")
    var productTitle: String?,

    @SerializedName("price")
    var productPrice: Double,

    @SerializedName("description")
    var productDescription: String?,

    @SerializedName("category")
    var productCategory: String?,

    @SerializedName("image")
    var productImageUrl: String?,

    @SerializedName("rate")
    var productRate: Double,

    @SerializedName("count")
    var productCount: Int,


    @SerializedName("saleState")
    var saleState: Int,


    ) : Parcelable
