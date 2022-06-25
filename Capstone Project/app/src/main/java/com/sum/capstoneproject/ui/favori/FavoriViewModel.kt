package com.sum.capstoneproject.ui.favori

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sum.capstoneproject.model.FavoriteRoomModel
import com.sum.capstoneproject.repository.ProductRepository

class FavoriViewModel(contex: Context) : ViewModel() {
    private val productRepo = ProductRepository(contex)

    private var _booksBasket = MutableLiveData<List<FavoriteRoomModel>>()
    val booksBasket: LiveData<List<FavoriteRoomModel>>
        get() = _booksBasket

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getFavori()
    }

    private fun getFavori() {
        productRepo.fav()
        _booksBasket = productRepo.productFavList
        _isLoading = productRepo.isLoading
    }

    fun deleteFavFrom(bookId: Int) {
        productRepo.deleteBookFromBasket(bookId)
        getFavori()
    }

}