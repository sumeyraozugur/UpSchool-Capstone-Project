package com.sum.capstoneproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sum.capstoneproject.model.ProductModel
import com.sum.capstoneproject.repository.ProductRepository

class HomeViewModel : ViewModel() {
    private val productRepo = ProductRepository()

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
        productRepo.books()
        _productList = productRepo.productList
        _isLoading = productRepo.isLoading

    }




}