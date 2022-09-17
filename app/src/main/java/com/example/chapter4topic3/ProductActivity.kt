package com.example.chapter4topic3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter4topic3.databinding.ActivityProductBinding
import kotlinx.android.synthetic.main.activity_buy_product.*

class ProductActivity : AppCompatActivity() {

    lateinit var vmProduk : ViewModelProduct
    lateinit var adapterProduk : ProdukAdapter
    lateinit var binding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        //isi data init viewmodel dan adapter
        vmProduk = ViewModelProvider(this).get(ViewModelProduct::class.java)

        //panggil viewmodel
        vmProduk.getProduct()

        //observe livedata
        vmProduk.product.observe(this, Observer {
            adapterProduk.setDataProduct(it as ArrayList<Product>)
        })

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product)

        adapterProduk = ProdukAdapter(ArrayList())
        binding.rvProduct.adapter = adapterProduk
        binding.rvProduct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapterProduk.onClick = {

        }
    }
}