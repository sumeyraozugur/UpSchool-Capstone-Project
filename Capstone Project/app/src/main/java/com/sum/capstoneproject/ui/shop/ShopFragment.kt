package com.sum.capstoneproject.ui.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sum.capstoneproject.R
import com.sum.capstoneproject.databinding.FragmentShopBinding


class ShopFragment : Fragment() {
    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ShopViewModel by viewModels()
    private val categoryProductsAdapter by lazy { ShopAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {

        with(binding) {

            with(viewModel) {

                isLoading.observe(viewLifecycleOwner) {
                    //if (!it) productLoadingView.visibility = View.GONE
                }



                categoryList.observe(viewLifecycleOwner) { list ->
                    shopRecycleView.apply {
                        setHasFixedSize(true)
                        adapter = categoryProductsAdapter.also { adapter ->
                            System.out.println(list)
                            adapter.updateList(list)
                        }
                    }
                }


            }
        }
    }

}