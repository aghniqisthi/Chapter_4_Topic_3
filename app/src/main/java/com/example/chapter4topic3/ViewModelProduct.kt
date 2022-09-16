package com.example.chapter4topic3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelProduct : ViewModel() {
    //declare data
    val list = arrayListOf(
        Product("Laptop", R.drawable.ic_launcher_foreground, 110000,  "New Arrival"),
        Product("Computer", R.drawable.ic_launcher_foreground, 120000,  "Vintage Like A New"),
        Product("Smartphone", R.drawable.ic_launcher_foreground, 130000,  "Hot Item"),
        Product("Smartwatch", R.drawable.ic_launcher_foreground, 140000,  "Modern Watch"),
        Product("Television", R.drawable.ic_launcher_foreground, 150000,  "Go Into Reality")
        )

    //live data mutable
    val product : MutableLiveData<List<Product>> = MutableLiveData()

    //set data ke livedata
    fun getProduct(){
        product.value = list
    }
}