package com.sum.capstoneproject.response

import com.google.gson.annotations.SerializedName
import com.sum.capstoneproject.model.ProductModel

data class ProductsResponse(
    @SerializedName("product") var product: List<ProductModel>,


)