package com.example.chapter4topic3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_buy_product.*

class BuyProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_product)

        var getData = intent.getSerializableExtra("produk") as Product
        namaBuy.text = getData.nama
        imageBuy.setImageResource(getData.img)
        hargaBuy.text = getData.harga.toString()
        descBuy.text = getData.desc

        btnBuy.setOnClickListener {
            val number = +6282231474110
            val pindah = Intent(Intent.ACTION_VIEW)
            pindah.data = Uri.parse(String.format("https://api.whatsapp.com/send?phone=$number&text="+"Hai! Saya tertarik dengan produk ${getData.nama} dengan harga $${getData.harga.toString()}, Apakah masih available?"))
            startActivity(pindah)
        }
    }
}