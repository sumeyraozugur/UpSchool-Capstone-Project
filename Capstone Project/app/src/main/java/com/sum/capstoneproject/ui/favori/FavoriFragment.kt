package com.sum.capstoneproject.ui.favori

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.sum.capstoneproject.R
import com.sum.capstoneproject.databinding.FragmentFavoriBinding


class FavoriFragment : Fragment() {
    private var _binding: FragmentFavoriBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy { FavoriViewModel(requireContext()) }
    private val allProductsAdapter by lazy { FavoriAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_favori, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()

        with(binding) {

            favRecycleView.setHasFixedSize(true)
            allProductsAdapter.onRemoveFavClick = {
                viewModel.deleteFavFrom(it)
            }


        }


    }

    private fun initObservers() {

        with(binding) {

            with(viewModel) {

              //  isLoading.observe(viewLifecycleOwner) {
                //    if (!it)
                //}

                booksBasket.observe(viewLifecycleOwner) { list ->
                    allProductsAdapter.updateList(list)
                    booksBasketRecyclerAdapter = allProductsAdapter
                    favRecycleView.adapter =allProductsAdapter
                   // Log.e("FavoriList",list.toString())

                 /*   if (list.isNotEmpty()) {
                        goToPayButton.setOnClickListener {
                            it.findNavController()
                                .navigate(R.id.action_booksBasketFragment_to_paymentFragment)
                        }
                    }*/
                }
            }
        }
    }

}