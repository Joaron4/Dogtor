package com.example.dogtorpet.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogtorpet.R
import com.example.dogtorpet.model.Products
import com.squareup.picasso.Picasso


class ProductsAdapter(val productsListener: ProductsListener) : RecyclerView.Adapter<ProductsAdapter.ViewHolder> () {

    var listProducts = ArrayList<Products>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.products_card,parent,false))

    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
        val products = listProducts[position]

        holder.tvNameProduct.text = products.nombre
        holder.tvPriceProduct.text = products.precio
        Picasso.get().load(products.url).into(holder.ivItemProduct)

        holder.itemView.setOnClickListener {
            productsListener.OnProductsClick(products, position)
        }
    }

    override fun getItemCount()= listProducts.size

    fun updateData(data: List<Products>) {
        listProducts.clear()
        listProducts.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNameProduct = itemView.findViewById<TextView>(R.id.tvNameProduct)
        val tvPriceProduct = itemView.findViewById<TextView>(R.id.tvPriceProduct)
        val ivItemProduct = itemView.findViewById<ImageView>(R.id.ivItemProduct)
    }
}