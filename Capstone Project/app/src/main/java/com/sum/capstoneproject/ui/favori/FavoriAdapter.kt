package com.sum.capstoneproject.ui.favori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sum.capstoneproject.databinding.ItemFavListBinding
import com.sum.capstoneproject.model.FavoriteRoomModel

class FavoriAdapter() : RecyclerView.Adapter<FavoriAdapter.FavoriHolder>() {
    private val favList = ArrayList<FavoriteRoomModel>()
    var onRemoveFavClick: (Int) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriHolder {
        val binding = ItemFavListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriHolder, position: Int) {
        holder.bind(favList[position])

    }

    inner class FavoriHolder(private var itemFavListBinding: ItemFavListBinding) :
        RecyclerView.ViewHolder(itemFavListBinding.root) {
        fun bind(favModel: FavoriteRoomModel) {

            itemFavListBinding.apply {

                itemFavObject = favModel
                //Log.e("error",favModel.toString())

                favModel.favImageUrl.let {
                    Picasso.get().load(it).into(itemFavImageView)
                }
                btnRemoveFav.setOnClickListener {
                    onRemoveFavClick(favModel.favId)
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