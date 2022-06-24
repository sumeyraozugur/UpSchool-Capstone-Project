package com.sum.capstoneproject.ui.home

import android.content.Context


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sum.capstoneproject.model.ProductModel
import com.sum.capstoneproject.repository.ProductRepository

class HomeViewModel(context:Context) : ViewModel() {
    private val productRepo = ProductRepository(context)

    private var _productList = MutableLiveData<List<ProductModel>>()
    val productList: LiveData<List<ProductModel>>
    get() = _productList

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getProduct()
    }

    private fun getProduct(){
        productRepo.products()
        _productList = productRepo.productList
        _isLoading = productRepo.isLoading

    }




}