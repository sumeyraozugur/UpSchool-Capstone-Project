package com.sum.capstoneproject.ui.favori

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sum.capstoneproject.model.FavoriteRoomModel
import com.sum.capstoneproject.repository.ProductRepository

class FavoriViewModel(contex: Context) : ViewModel() {
    private val productRepo = ProductRepository(contex)

    private var _productsFavorite = MutableLiveData<List<FavoriteRoomModel>>()
    val productsFavorite: LiveData<List<FavoriteRoomModel>>
        get() = _productsFavorite

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    init {
        getFavori()
    }

    private fun getFavori() {
        productRepo.fav()
        _productsFavorite = productRepo.productFavList
        _isLoading = productRepo.isLoading
    }

    fun deleteFavFrom(favId: Int) {
        productRepo.deleteProductsFromFav(favId)
        getFavori()
    }

}