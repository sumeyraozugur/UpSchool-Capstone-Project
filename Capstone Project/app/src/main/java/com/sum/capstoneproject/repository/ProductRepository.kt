package com.sum.capstoneproject.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sum.capstoneproject.model.FavoriteRoomModel
import com.sum.capstoneproject.model.ProductModel
import com.sum.capstoneproject.retrofit.ProductApi
import com.sum.capstoneproject.room.FavProductDao
import com.sum.capstoneproject.room.FavProductDatabase
import com.sum.capstoneproject.util.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository(context: Context) {
    var productList = MutableLiveData<List<ProductModel>>()
    var categoryList = MutableLiveData<List<String>>()
    var productFavList = MutableLiveData<List<FavoriteRoomModel>>()
    var isLoading = MutableLiveData<Boolean>()
    var isFavAdded = MutableLiveData<Boolean>()

    private val productsDIF: ProductApi = ApiUtils.getProductsDAOInterface()
    private val favProductDao: FavProductDao? =
        FavProductDatabase.favProductDatabase(context)?.favProductDAOInterface()


    fun products() {
        isLoading.value = true
        productsDIF.allProduct().enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>,
            ) {

                response.body()?.let {
                    productList.value = it
                    isLoading.value = false
                } ?: run {
                    isLoading.value = false
                }

            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                t.localizedMessage?.toString()?.let { Log.e("Books Failure", it) }
                isLoading.value = false
            }


        })
    }

    fun category() {
        isLoading.value = true

        with(productsDIF) {
            getCategories().enqueue(object : Callback<List<String>> {
                override fun onResponse(
                    call: Call<List<String>>,
                    response: Response<List<String>>,
                ) {

                    response.body()?.let {
                        categoryList.value = it
                        System.out.println(it)
                        isLoading.value = false
                    } ?: run {
                        isLoading.value = false
                    }

                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    t.localizedMessage?.toString()?.let { Log.e("Books Failure", it) }
                    isLoading.value = false
                }


            })
        }

    }

    fun fav() {
        isLoading.value = true

        favProductDao?.getFavProduct()?.let {
            productFavList.value = it
            System.out.println(it)
            isLoading.value = false
        } ?: run {
            isLoading.value = false
        }
    }

    fun addFav(favModel: FavoriteRoomModel) {

        favProductDao?.getFavNames()?.let {

            isFavAdded.value = if (it.contains(favModel.favName).not()) {
                favProductDao.addFav(favModel)
                true
            } else {
                false
            }
        }
    }



}
