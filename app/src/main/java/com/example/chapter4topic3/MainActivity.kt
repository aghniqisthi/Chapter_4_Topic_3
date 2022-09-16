package com.example.chapter4topic3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter4topic3.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var vmProduk : ViewModelProduct
    lateinit var adapterProduk : ProdukAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //isi data init viewmodel dan adapter
        vmProduk = ViewModelProvider(this).get(ViewModelProduct::class.java)
        adapterProduk = ProdukAdapter(ArrayList())

        //panggil viewmodel
        vmProduk.getProduct()

        //observe livedata
        vmProduk.product.observe(this, Observer {
            adapterProduk.setDataProduct(it as ArrayList<Product>)
        })

        binding.rvProduct.adapter = adapterProduk
        binding.rvProduct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}

