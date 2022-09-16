package com.example.chapter4topic3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter4topic3.databinding.ActivityMainBinding
import com.example.chapter4topic3.databinding.ItemProdukBinding

class ProdukAdapter(var listProduct:ArrayList<Product>) : RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemProdukBinding): RecyclerView.ViewHolder(binding.root) {
        fun dataBinding(itemData : Product){
            binding.produk = itemData
        }
//        var name = itemView.findViewById<TextView>(R.id.namaProduk)
//        var harga = itemView.findViewById<TextView>(R.id.hargaProduk)
//        var gambar = itemView.findViewById<ImageView>(R.id.imgProduk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukAdapter.ViewHolder {
        var view = ItemProdukBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdukAdapter.ViewHolder, position: Int) {
        holder.dataBinding(listProduct[position])
//        holder.name.text = listProduct[position].nama
//        holder.harga.text = listProduct[position].harga.toString()
//        holder.gambar.setImageResource(listProduct[position].img)
    }

    override fun getItemCount(): Int = listProduct.size

    fun setDataProduct(itemData:ArrayList<Product>){
        this.listProduct = itemData
    }
}