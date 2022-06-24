package com.sum.capstoneproject.ui.favori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sum.capstoneproject.databinding.ItemFavListBinding
import com.sum.capstoneproject.model.FavoriteRoomModel

class FavoriAdapter() : RecyclerView.Adapter<FavoriAdapter.FavoriHolder>() {
    private val favList = ArrayList<FavoriteRoomModel>()

    class FavoriHolder(val binding: ItemFavListBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriHolder {
        val binding = ItemFavListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriAdapter.FavoriHolder, position: Int) {
        holder.binding.itemFavObject = favList[position]


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