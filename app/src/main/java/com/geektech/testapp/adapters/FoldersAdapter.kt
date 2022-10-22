package com.geektech.testapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.testapp.databinding.FolderItemBinding

class FoldersAdapter : RecyclerView.Adapter<FoldersAdapter.MyViewHolder>() {

    var onItemClick: ((Boolean) -> Unit)? = null

    class MyViewHolder(val binding: (FolderItemBinding)) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            FolderItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.moreButton.setOnClickListener {
            onItemClick?.invoke(true)
        }
    }

    override fun getItemCount(): Int = 1
}
