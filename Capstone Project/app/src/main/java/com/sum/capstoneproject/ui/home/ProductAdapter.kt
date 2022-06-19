package com.sum.capstoneproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sum.capstoneproject.databinding.ItemNewProductListBinding
import com.sum.capstoneproject.model.ProductModel
import java.util.ArrayList


class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    private val productList = ArrayList<ProductModel>()

    class ProductHolder(val binding: ItemNewProductListBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val binding =
            ItemNewProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val productImage = holder.binding.itemNewProduct
       // val productName = holder.binding.textHomeProductName


        //productName.text = productList.get(position).productTitle
        holder.binding.itemNewProductObject = productList[position]



        Glide.with(holder.itemView.context).load(productList.get(position).productImageUrl)
            .into(productImage)


    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun updateList(list: List<ProductModel>) {
        productList.clear()
        productList.addAll(list)
        notifyDataSetChanged()
    }

}
