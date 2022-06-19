package com.sum.capstoneproject.util

import com.sum.capstoneproject.retrofit.ProductApi
import com.sum.capstoneproject.retrofit.RetrofitClient


class ApiUtils {

    companion object {
        private const val BASE_URL = "https://canerture.com/api/ecommerce/" // https://canerture.com/api/ecommerce/sign_up.php
        fun getBooksDAOInterface(): ProductApi {
            return RetrofitClient.getClient(BASE_URL).create(ProductApi::class.java)
        }




    }
}