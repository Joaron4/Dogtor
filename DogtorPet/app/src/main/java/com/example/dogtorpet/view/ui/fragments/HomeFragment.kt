package com.example.dogtorpet.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogtorpet.R
import com.example.dogtorpet.databinding.FragmentHomeBinding
import com.example.dogtorpet.model.Products
import com.example.dogtorpet.view.adapter.ProductsAdapter
import com.example.dogtorpet.view.adapter.ProductsListener
import com.example.dogtorpet.viewmodel.HomeViewModel


class HomeFragment : Fragment(), ProductsListener {
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHomeUser
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        homeViewModel.refresh()

        productsAdapter = ProductsAdapter(this)

        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = productsAdapter
        }

        observeViewModel()
    }

    fun observeViewModel() {
        homeViewModel.listProducts.observe(viewLifecycleOwner, Observer<List<Products>> { products ->
            productsAdapter.updateData(products)
        })

        homeViewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean>{
            if (it != null)
                binding.homeComponents.visibility = View.INVISIBLE
        })
    }

    override fun OnProductsClick(product: Products, position: Int) {
        TODO("Not yet implemented")
    }


}