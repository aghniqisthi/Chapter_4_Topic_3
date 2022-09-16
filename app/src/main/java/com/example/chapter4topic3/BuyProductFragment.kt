package com.example.chapter4topic3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_buy_product.*
import kotlinx.android.synthetic.main.item_produk.*

class BuyProductFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var getData = arguments?.getSerializable("produk") as Product

        namaBuy.text = getData.nama
        imageBuy.setImageResource(getData.img)
        hargaBuy.text = getData.harga.toString()
        descBuy.text = getData.desc
    }
}