package com.sum.capstoneproject.util

import com.sum.capstoneproject.retrofit.ProductApi
import com.sum.capstoneproject.retrofit.RetrofitClient


class ApiUtils {

    companion object {
        private const val BASE_URL = "https://api.canerture.com/ecommerce/"
        fun getProductsDAOInterface(): ProductApi {
            return RetrofitClient.getClient(BASE_URL).create(ProductApi::class.java)
        }
    }
}