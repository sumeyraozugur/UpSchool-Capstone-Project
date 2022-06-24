package com.sum.capstoneproject.ui.favori

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sum.capstoneproject.model.FavoriteRoomModel
import com.sum.capstoneproject.repository.ProductRepository

class FavoriViewModel(contex: Context) : ViewModel() {
    private val booksRepo = ProductRepository(contex)

    private var _booksBasket = MutableLiveData<List<FavoriteRoomModel>>()
    val booksBasket: LiveData<List<FavoriteRoomModel>>
        get() = _booksBasket

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getBooksBasket()
    }

    private fun getBooksBasket() {
        booksRepo.fav()
        _booksBasket = booksRepo.productFavList
        _isLoading = booksRepo.isLoading
    }

}