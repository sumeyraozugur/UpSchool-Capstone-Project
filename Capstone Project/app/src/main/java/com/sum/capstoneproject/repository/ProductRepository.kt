package com.sum.capstoneproject.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sum.capstoneproject.model.ProductModel
import com.sum.capstoneproject.response.ProductsResponse
import com.sum.capstoneproject.retrofit.ProductApi
import com.sum.capstoneproject.util.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository{
    var productList = MutableLiveData<List<ProductModel>>()
    var isLoading = MutableLiveData<Boolean>()

    private val booksDIF: ProductApi = ApiUtils.getBooksDAOInterface()


    fun books() {
        isLoading.value = true
        booksDIF.allProduct().enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(call: Call<ProductsResponse>, response: Response<ProductsResponse>) {

                response.body()?.product?.let {
                    productList.value = it
                    isLoading.value = false
                } ?: run {
                    isLoading.value = false
                }

            }

            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Books Failure", it) }
                isLoading.value = false
            }


        })
    }
}
