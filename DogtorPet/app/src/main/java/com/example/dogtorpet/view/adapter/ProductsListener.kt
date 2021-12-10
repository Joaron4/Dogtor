package com.example.dogtorpet.view.adapter

import com.example.dogtorpet.model.Products

interface ProductsListener {
    fun OnProductsClick(product:Products, position: Int)
}