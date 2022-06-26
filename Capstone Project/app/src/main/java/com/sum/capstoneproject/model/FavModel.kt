package com.sum.capstoneproject.model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
class FavModel (
    @SerializedName("fav_id") @Expose
    var favId: Int? = 0,

    @SerializedName("fav_title") @Expose
    var favTitle: String?,

    @SerializedName("fav_description") @Expose
    var favDescription: String?,

    @SerializedName("fav_price") @Expose
    var favPrice: Double,

   // @SerializedName("fav_user") @Expose
    //var favUser: String?,

    @SerializedName("fav_image_url") @Expose
    var favImageUrl: String?) : Parcelable
