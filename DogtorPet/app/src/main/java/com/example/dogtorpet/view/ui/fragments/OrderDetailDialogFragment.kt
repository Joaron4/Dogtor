package com.example.dogtorpet.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.dogtorpet.databinding.FragmentOrderDetailDialogBinding
import com.example.dogtorpet.model.Products
import com.squareup.picasso.Picasso

class OrderDetailDialogFragment : DialogFragment() {

    private var _binding: FragmentOrderDetailDialogBinding? = null
    private val bindign get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderDetailDialogBinding.inflate(inflater,container,false)
        var view = bindign.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val products = arguments?.getSerializable("product") as Products
        bindign.tvNameProduct.text = products.nombre
        bindign.tvPriceProduct.text = products.precio
        Picasso.get().load(products.url).into(bindign.ivProduct)

        bindign.btBuyProduct.setOnClickListener{
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT)
    }
}