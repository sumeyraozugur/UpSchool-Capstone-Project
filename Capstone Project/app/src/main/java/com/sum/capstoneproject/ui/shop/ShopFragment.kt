package com.sum.capstoneproject.ui.shop

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sum.capstoneproject.R
import com.sum.capstoneproject.databinding.FragmentShopBinding


class ShopFragment : Fragment() {
    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!


    private val viewModel by lazy { ShopViewModel(requireContext()) }
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
        setHasOptionsMenu(true)
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

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.search_menu, menu)

        //val item = menu.findItem(R.id.ic_search)
        //val searchView = item.actionView as SearchView
        //searchView.setOnQueryTextListener(this)


    }


}