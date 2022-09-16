package com.example.chapter4topic3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter4topic3.databinding.ActivityMainBinding
import com.example.chapter4topic3.databinding.FragmentProductBinding

class ProductFragment : Fragment() {
    lateinit var vmProduk : ViewModelProduct
    lateinit var adapterProduk : ProdukAdapter
    lateinit var binding: FragmentProductBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProductBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //isi data init viewmodel dan adapter
        vmProduk = ViewModelProvider(this).get(ViewModelProduct::class.java)
        adapterProduk = ProdukAdapter(ArrayList())

        //panggil viewmodel
        vmProduk.getProduct()

        //observe livedata
        vmProduk.product.observe(viewLifecycleOwner, Observer {
            adapterProduk.setDataProduct(it as ArrayList<Product>)
        })

        binding.rvProduct.adapter = adapterProduk
        binding.rvProduct.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }
}