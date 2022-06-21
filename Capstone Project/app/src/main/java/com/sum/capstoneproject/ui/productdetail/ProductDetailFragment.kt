package com.sum.capstoneproject.ui.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sum.capstoneproject.R
import com.sum.capstoneproject.databinding.FragmentProductDetailBinding
import com.sum.capstoneproject.model.ProductModel


class ProductDetailFragment : Fragment() {
    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductDetailViewModel by viewModels()
    private var productModel:ProductModel?=null
    private val args: ProductDetailFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false)
        return binding.root



      //  binding.detailFragmentObject = productModel

     //   binding.textViewDetailName.text = productModel!!.productTitle


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = args.objectProduct

        binding.apply {

            detailFragmentObject = product

        }
//Detaya görseli getirme
        Glide.with(this).load(product.productImageUrl)
            .into(binding.imageViewDetail)



    }

}