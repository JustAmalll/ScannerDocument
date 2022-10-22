package com.geektech.testapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.testapp.databinding.ItemAddSignatureBinding

class AddSignatureAdapter : RecyclerView.Adapter<AddSignatureAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: (ItemAddSignatureBinding)) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            ItemAddSignatureBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = 4
}
