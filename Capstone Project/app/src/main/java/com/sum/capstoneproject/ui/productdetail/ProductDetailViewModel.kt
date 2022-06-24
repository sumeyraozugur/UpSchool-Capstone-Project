package com.sum.capstoneproject.ui.productdetail

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sum.capstoneproject.model.FavoriteRoomModel
import com.sum.capstoneproject.repository.ProductRepository

class ProductDetailViewModel(context: Context): ViewModel() {
    private val productRepo = ProductRepository(context)


    private var _isFavAdded = MutableLiveData<Boolean>()
    val isFavAdded: LiveData<Boolean>
        get() = _isFavAdded

    init {
        _isFavAdded = productRepo.isFavAdded
    }

    fun addFav(favModel:FavoriteRoomModel) {
        productRepo.addFav(favModel)
    }


}