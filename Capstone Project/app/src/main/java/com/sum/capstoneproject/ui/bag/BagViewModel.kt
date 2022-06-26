package com.sum.capstoneproject.ui.bag

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sum.capstoneproject.model.ProductModel
import com.sum.capstoneproject.repository.ProductRepository

class BagViewModel(context: Context) : ViewModel() {
    private var bagRepo = ProductRepository(context)

    private var _bagList = MutableLiveData<List<ProductModel>>()
    val bagList: LiveData<List<ProductModel>>
        get() = _bagList


    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading




     fun getBagProducts(user: String) {
        bagRepo.getBagProducts(user)
        _bagList = bagRepo.basketList
         _isLoading = bagRepo.isLoading
    }

}