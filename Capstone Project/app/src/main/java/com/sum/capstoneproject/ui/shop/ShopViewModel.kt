package com.sum.capstoneproject.ui.shop

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sum.capstoneproject.repository.ProductRepository

class ShopViewModel(contex:Context) : ViewModel() {
    private var shopRepo = ProductRepository(contex)

    private var _categoryList = MutableLiveData<List<String>>()
    val categoryList: LiveData<List<String>>
        get() = _categoryList

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getCategory()
    }

    private fun getCategory() {
        shopRepo.category()
        _categoryList = shopRepo.categoryList
        _isLoading = shopRepo.isLoading

    }
}