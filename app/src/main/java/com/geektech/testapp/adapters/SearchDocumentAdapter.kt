package com.geektech.testapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.geektech.testapp.R
import com.geektech.testapp.databinding.DocumentItemBinding

class SearchDocumentAdapter : RecyclerView.Adapter<SearchDocumentAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: (DocumentItemBinding)) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            DocumentItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.documentTypeCardView.visibility = View.GONE
        holder.binding.documentItemContainer.setOnClickListener {
            it.findNavController().navigate(R.id.action_filesFragment_to_separateDocumentFragment)
        }
        holder.binding.documentItemContainer.setOnLongClickListener {
            it.findNavController().navigate(R.id.action_filesFragment_to_moveFoldersFragment)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int = 8
}
