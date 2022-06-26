package com.sum.capstoneproject.ui.bag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.sum.capstoneproject.R
import com.sum.capstoneproject.databinding.FragmentBagBinding


class BagFragment : Fragment() {
    private var _binding: FragmentBagBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy { BagViewModel(requireContext()) }
    private val bagAdapter by lazy { BagAdapter() }

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

        FirebaseAuth.getInstance().currentUser?.let {
            viewModel.getBagProducts(it.uid)
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
                        productsBagRecyclerAdapter=bagAdapter

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