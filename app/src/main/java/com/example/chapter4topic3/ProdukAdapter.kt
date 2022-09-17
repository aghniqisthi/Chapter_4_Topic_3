package com.example.chapter4topic3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter4topic3.databinding.ActivityMainBinding
import com.example.chapter4topic3.databinding.ItemProdukBinding

class ProdukAdapter(var listProduct:ArrayList<Product>) : RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {

    var onClick : ((Product) -> Unit)? = null

    class ViewHolder(val binding: ItemProdukBinding): RecyclerView.ViewHolder(binding.root) {
        fun dataBinding(itemData : Product){
            binding.produk = itemData
            binding.cardProduct.setOnClickListener(object: View.OnClickListener{
                override fun onClick(view: View?) {
                    var bundle = Bundle()
                    bundle.putSerializable("produk", itemData)
                    val intent = Intent(view!!.context, BuyProductActivity::class.java)
                    intent.putExtras(bundle)
                    view.context.startActivity(intent)
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukAdapter.ViewHolder {
        var view = ItemProdukBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdukAdapter.ViewHolder, position: Int) {
        holder.dataBinding(listProduct[position])
    }

    override fun getItemCount(): Int = listProduct.size

    fun setDataProduct(itemData:ArrayList<Product>){
        this.listProduct = itemData
    }
}