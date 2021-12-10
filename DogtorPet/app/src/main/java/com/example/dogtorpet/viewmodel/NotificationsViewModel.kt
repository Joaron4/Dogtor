package com.example.dogtorpet.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogtorpet.model.Products
import com.example.dogtorpet.network.Callback
import com.example.dogtorpet.network.FirestoreService
import java.lang.Exception

<<<<<<< Updated upstream:DogtorPet/app/src/main/java/com/example/dogtorpet/viewmodel/NotificationsViewModel.kt
class NotificationsViewModel : ViewModel() {
=======
class OrderViewModel : ViewModel() {
    val firestoreService = FirestoreService()
    val listProducts : MutableLiveData<List<Products>?> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getProductsFromFrirebase()
    }
    fun getProductsFromFrirebase(){
        firestoreService.getProducts(object : Callback<List<Products>>{
            override fun onSuccess(result : List<Products>?){
                listProducts.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }
    fun processFinished(){
        isLoading.value=true
    }
>>>>>>> Stashed changes:DogtorPet/app/src/main/java/com/example/dogtorpet/viewmodel/OrderViewModel.kt

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}