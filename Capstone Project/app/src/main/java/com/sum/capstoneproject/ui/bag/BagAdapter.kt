package com.sum.capstoneproject.ui.bag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sum.capstoneproject.databinding.ItemBagListBinding
import com.sum.capstoneproject.model.ProductModel

class BagAdapter : RecyclerView.Adapter<BagAdapter.BagHolder>() {
    private val bagList = ArrayList<ProductModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BagHolder {
        val binding = ItemBagListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BagHolder(binding)
    }

    override fun onBindViewHolder(holder: BagAdapter.BagHolder, position: Int) {
        holder.bind(bagList[position])
    }

    inner class BagHolder(private var itemBagListBinding: ItemBagListBinding) :
        RecyclerView.ViewHolder(itemBagListBinding.root) {

        fun bind(product: ProductModel) {

        }
    }


    override fun getItemCount(): Int {
        return bagList.size
    }

    fun updateList(list: List<ProductModel>) {
        bagList.clear()
        bagList.addAll(list)
        notifyDataSetChanged()
    }
}