package com.example.dogtorpet.network

import java.lang.Exception

interface Callback <T>{
    fun onSuccess(result: T?)

    fun onFailed(exception: Exception)
}