package com.sum.capstoneproject.ui.shop

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.sum.capstoneproject.databinding.ItemListShopBinding


class ShopAdapter : RecyclerView.Adapter<ShopAdapter.ShopHolder>(), Filterable {
    private val categoryList = ArrayList<String>()
    var categoryFilterList = ArrayList<String>()

    init {
        categoryFilterList =categoryList
    }

    class ShopHolder(val binding: ItemListShopBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopHolder {
        val binding =
            ItemListShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShopAdapter.ShopHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopHolder, position: Int) {
        val productCategory = holder.binding.itemTextCategory
        holder.binding.itemCategoryObject = categoryList[position]

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun updateList(list: List<String>) {
        categoryList.clear()
        categoryList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {

                val searchText = constraint.toString().lowercase()
                categoryFilterList = if (searchText.isEmpty()) {
                    categoryList
                } else {
                    val resultList = ArrayList<String>()

                    resultList
                }

                val filterResults = FilterResults()
                filterResults.values = categoryFilterList

                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                categoryFilterList = p1?.values as ArrayList<String>
                notifyDataSetChanged()
            }
        }
    }
}

