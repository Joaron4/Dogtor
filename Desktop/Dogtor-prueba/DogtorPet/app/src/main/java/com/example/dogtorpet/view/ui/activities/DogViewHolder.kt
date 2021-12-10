package com.example.dogtorpet.view.ui.activities

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.dogtorpet.databinding.ProductsCardBinding

class DogViewHolder (view:View):RecyclerView.ViewHolder(view) {
    private val binding = ProductsCardBinding.bind(view)
    fun bind(image:String){
        Picasso.get().load(image).into(binding.ivItemProduct)
    }
}