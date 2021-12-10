package com.example.dogtorpet.network

import com.example.dogtorpet.model.Products
import com.google.firebase.firestore.FirebaseFirestore



const val PRODUCT_COLLECTION_NAME="products"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()

    fun getProducts(callback: Callback<List<Products>>){
        firebaseFirestore.collection(PRODUCT_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result){
                    val list = result.toObjects(Products::class.java)
                    callback.onSuccess(list)
                    break
                }

            }

    }

}