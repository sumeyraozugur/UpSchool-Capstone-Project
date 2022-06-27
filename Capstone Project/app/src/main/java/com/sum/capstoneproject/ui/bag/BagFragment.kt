package com.sum.capstoneproject.ui.bag

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.sum.capstoneproject.R
import com.sum.capstoneproject.databinding.FragmentBagBinding


class BagFragment : Fragment() {
    private var _binding: FragmentBagBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy { BagViewModel(requireContext()) }
    private val bagAdapter by lazy { BagAdapter() }
    var firebaseUser =FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bag, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseUser?.let {
            viewModel.getBagProducts(it.uid)
        }
        with(binding) {

           // bagRecyclerView.setHasFixedSize(true)
            bagAdapter.onRemoveBasketClick = {
                //Log.v("onRemove",it.toString())
                viewModel.deleteBagFrom(it,  firebaseUser!!.uid)
               Log.v("onRemove",firebaseUser!!.uid)
            }



        }

        initObservers()
    }

    private fun initObservers() {
        with(binding) {
            with(viewModel) {

                bagList.observe(viewLifecycleOwner) { productList ->
                    bagRecyclerView.apply {
                        setHasFixedSize(true)
                        bagAdapter.updateList(productList)
                        productsBagRecyclerAdapter = bagAdapter


                        if (productList.isNotEmpty()) {
                            btnBagBasket.setOnClickListener {
                                it.findNavController()
                                    .navigate(R.id.action_bagFragment_to_successFragment)
                            }

                        }


                    }


                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }


}