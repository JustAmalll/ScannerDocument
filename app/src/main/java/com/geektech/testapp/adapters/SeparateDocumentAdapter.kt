package com.geektech.testapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.geektech.testapp.R
import com.geektech.testapp.databinding.ItemSeparateDocumentBinding

class SeparateDocumentAdapter : RecyclerView.Adapter<SeparateDocumentAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: (ItemSeparateDocumentBinding)) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            ItemSeparateDocumentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.container.setOnLongClickListener {
            it.findNavController().navigate(
                R.id.action_separateDocumentFragment_to_bulkEditingFragment
            )
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int = 8
}
