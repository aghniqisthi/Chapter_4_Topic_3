package com.example.chapter4topic3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelProduct : ViewModel() {
    //declare data
    val list = arrayListOf(
        Product("Laptop", R.drawable.laptop, 110000,  "New Arrival"),
        Product("Computer", R.drawable.computer, 120000,  "Vintage Like A New"),
        Product("Smartphone", R.drawable.smartphone, 130000,  "Hot Item"),
        Product("Smartwatch", R.drawable.smartwatch, 140000,  "Modern Watch"),
        Product("Television", R.drawable.television, 150000,  "Go Into Reality")
        )

    //live data mutable
    val product : MutableLiveData<List<Product>> = MutableLiveData()

    //set data ke livedata
    fun getProduct(){
        product.value = list
    }
}