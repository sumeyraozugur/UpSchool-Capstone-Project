package com.sum.capstoneproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sum.capstoneproject.R
import com.sum.capstoneproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private val allBooksAdapter by lazy { ProductRecyclerAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }

    private fun initObservers() {

        with(binding) {

            with(viewModel) {

                isLoading.observe(viewLifecycleOwner) {
                    //if (!it) productLoadingView.visibility = View.GONE
                }



                productList.observe(viewLifecycleOwner) { list ->
                    homeNewProductRecycle.apply {
                        setHasFixedSize(true)
                        adapter = allBooksAdapter.also { adapter ->
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