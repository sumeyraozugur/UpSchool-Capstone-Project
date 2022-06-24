package com.sum.capstoneproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "product_fav_database")
data class FavoriteRoomModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var favId: Int = 0,

    @ColumnInfo(name = "fav_name")
    var favName: String?,

    @ColumnInfo(name ="fav_price")
    var favPrice: String?,

    @ColumnInfo(name = "fav_ImageUrl")
    var favImageUrl: String?


)