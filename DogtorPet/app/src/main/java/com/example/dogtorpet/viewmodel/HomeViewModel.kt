package com.example.dogtorpet.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dogtorpet.model.Products
import com.example.dogtorpet.network.Callback
import com.example.dogtorpet.network.FirestoreService
import java.lang.Exception

class HomeViewModel : ViewModel() {
    val firestoreService = FirestoreService()
    val listProducts: MutableLiveData<List<Products>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()







    fun refresh() {
        getProductsFromFirebase()
    }

    private fun getProductsFromFirebase() {
        firestoreService.getProducts(object : Callback<List<Products>> {

            override fun onFailed(exception: Exception) {
                processFinished()
            }

            override fun onSuccess(result: List<Products>?) {
                listProducts.postValue(result)
                processFinished()
            }

        })
    }

    fun processFinished() {
        isLoading.value = true
    }



     private val _text = MutableLiveData<String>().apply {
        value = "Hola"
    }



    val text: LiveData<String> = _text




}