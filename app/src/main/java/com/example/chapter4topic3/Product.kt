package com.example.chapter4topic3

import java.io.Serializable

data class Product(var nama: String, var img:Int, var harga:Int,  var desc:String) : Serializable
