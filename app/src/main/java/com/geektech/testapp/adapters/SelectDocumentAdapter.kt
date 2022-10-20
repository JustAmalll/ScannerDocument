package com.geektech.testapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.testapp.databinding.SelectDocumentItemBinding

class SelectDocumentAdapter : RecyclerView.Adapter<SelectDocumentAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: SelectDocumentItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            SelectDocumentItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.container.setOnClickListener {
            holder.binding.selectedIcon.visibility = View.VISIBLE
            holder.binding.bgFill.visibility = View.VISIBLE
            holder.binding.unselectedIcon.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = 27
}
