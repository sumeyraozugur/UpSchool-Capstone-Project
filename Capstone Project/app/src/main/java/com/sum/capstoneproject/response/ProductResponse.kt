package com.sum.capstoneproject.response

import com.google.gson.annotations.SerializedName
import com.sum.capstoneproject.model.ProductModel

data class ProductsResponse(
    @SerializedName("books") var books: List<ProductModel>,
    @SerializedName("success") var success: Int


)