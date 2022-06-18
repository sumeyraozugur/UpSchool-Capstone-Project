package com.sum.capstoneproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sum.capstoneproject.R
import com.sum.capstoneproject.model.ProductModel

class ProductAdapter(val  productList: ArrayList<ProductModel>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    class ProductViewHolder(var view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_new_product_list,parent,false)
        return  ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun updateList(list: List<ProductModel>) {
        productList.clear()
        notifyDataSetChanged()
    }


}