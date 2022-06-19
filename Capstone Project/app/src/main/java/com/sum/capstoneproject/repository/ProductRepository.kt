package com.sum.capstoneproject.repository

import androidx.lifecycle.MutableLiveData
import com.sum.capstoneproject.model.ProductModel
import com.sum.capstoneproject.retrofit.ProductApi
import com.sum.capstoneproject.util.ApiUtils

class ProductRepository {
    var booksList = MutableLiveData<List<ProductModel>>()
    var bestSellersList = MutableLiveData<List<ProductModel>>()
    var isLoading = MutableLiveData<Boolean>()

    private val booksDIF: ProductApi = ApiUtils.getBooksDAOInterface()


}