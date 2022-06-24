package com.sum.capstoneproject.model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
class FavModel (
    @SerializedName("fav_id") @Expose
    var fav_id: Int? = 0,
    @SerializedName("fav_name") @Expose
    var fav_name: String?,
    @SerializedName("fav_price") @Expose
    var fav_price: String?,
    @SerializedName("fav_image_url") @Expose
    var fav_image_url: String?) : Parcelable