package com.sum.capstoneproject.ui.favori

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sum.capstoneproject.databinding.ItemFavListBinding
import com.sum.capstoneproject.model.FavoriteRoomModel
import com.sum.capstoneproject.ui.home.HomeFragmentDirections

class FavoriAdapter() : RecyclerView.Adapter<FavoriAdapter.FavoriHolder>() {
    private val favList = ArrayList<FavoriteRoomModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriHolder {
        val binding = ItemFavListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriHolder(binding)
    }

    override fun onBindViewHolder(holder:FavoriHolder, position: Int) {
        holder.bind(favList[position])

    }

    inner class FavoriHolder(private var bestSellerItemBinding: ItemFavListBinding) :
        RecyclerView.ViewHolder(bestSellerItemBinding.root) {
        fun bind(favModel: FavoriteRoomModel) {

            bestSellerItemBinding.apply {

                itemFavObject = favModel
                Log.e("error",favModel.toString())

                favModel.favImageUrl.let {
                    Picasso.get().load(it).into(itemFavImageView)
                }





            }
        }
    }

    override fun getItemCount(): Int {
        return favList.size
    }

    fun updateList(list: List<FavoriteRoomModel>) {
        favList.clear()
        favList.addAll(list)
        notifyDataSetChanged()
    }
}