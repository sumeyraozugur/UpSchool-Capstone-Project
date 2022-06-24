package com.sum.capstoneproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sum.capstoneproject.databinding.ItemNewProductListBinding
import com.sum.capstoneproject.model.ProductModel



class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    private val productList = ArrayList<ProductModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val binding =
            ItemNewProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(productList[position])
    }

    inner class ProductHolder(private var bestSellerItemBinding: ItemNewProductListBinding) :
        RecyclerView.ViewHolder(bestSellerItemBinding.root) {

        fun bind(product: ProductModel) {

            bestSellerItemBinding.apply {

                itemNewProductObject = product

                product.productImageUrl.let {
                    Picasso.get().load(it).into(itemNewProduct)
                }

                itemNewProduct.setOnClickListener {
                    val action =HomeFragmentDirections.actionHomeFragmentToProductDetailFragment(product)

                    Navigation.findNavController(it).navigate(action)

                }


            }
        }
    }

    // val productImage = holder.binding.itemNewProduct
    // val productName = holder.binding.textHomeProductName


    //productName.text = productList.get(position).productTitle
    //holder.binding.itemNewProductObject =


    override fun getItemCount(): Int {
        return productList.size
    }

    fun updateList(list: List<ProductModel>) {
        productList.clear()
        productList.addAll(list)
        notifyDataSetChanged()
    }

}