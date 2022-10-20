package com.geektech.testapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.testapp.databinding.DocumentItemBinding

class DeepCleanAdapter : RecyclerView.Adapter<DeepCleanAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: DocumentItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            DocumentItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.documentItemContainer.setOnClickListener {
            holder.binding.selectedBg.visibility = View.VISIBLE
            holder.binding.selectedCheck.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int = 4
}
