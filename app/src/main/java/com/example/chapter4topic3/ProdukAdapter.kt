package com.example.chapter4topic3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter4topic3.databinding.ActivityMainBinding
import com.example.chapter4topic3.databinding.ItemProdukBinding

class ProdukAdapter(var listProduct:ArrayList<Product>) : RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemProdukBinding): RecyclerView.ViewHolder(binding.root) {
        fun dataBinding(itemData : Product){
            binding.produk = itemData
            binding.cardProduct.setOnClickListener{
                var bundle = Bundle()
                bundle.putSerializable("produk", itemData)
                Navigation.findNavController(itemView).navigate(R.id.action_productFragment_to_buyProductFragment, bundle)
            }
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