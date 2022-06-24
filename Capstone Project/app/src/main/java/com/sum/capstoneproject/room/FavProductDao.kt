package com.sum.capstoneproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sum.capstoneproject.model.FavoriteRoomModel


@Dao
interface FavProductDao {

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun addFav(booksBasketRoomModel: FavoriteRoomModel)

    @Query("SELECT fav_price FROM product_fav_database")
    fun getFavPrice (): List<String>?

    @Query("SELECT fav_name  FROM product_fav_database")
    fun getFavNames(): List<String>?

    @Query("SELECT * FROM product_fav_database ")
    fun getFavProduct(): List<FavoriteRoomModel>?

    @Query("DELETE FROM product_fav_database WHERE id = :idInput")
    fun deleteFavWithId(idInput: Int)

    @Query("DELETE FROM product_fav_database")
    fun clearFav()


}