package com.sum.capstoneproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sum.capstoneproject.R
import com.sum.capstoneproject.databinding.ItemNewProductListBinding
import com.sum.capstoneproject.model.ProductModel

class ProductRecyclerAdapter(val productList : List<ProductModel>, private val listener:Listener) : RecyclerView.Adapter<ProductRecyclerAdapter.ProductHolder>() {
    class ProductHolder(val binding: ItemNewProductListBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val binding = ItemNewProductListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val productImage = holder.itemView.findViewById<ImageView>(R.id.itemNewProduct)




        Glide.with(holder.itemView.context).load(productList.get(position).productImageUrl).into(productImage)




    }

    override fun getItemCount(): Int {
        return productList.size
    }
    interface Listener {
        fun onItemClick(product: ProductModel)
    }
}