package com.geektech.testapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.testapp.databinding.ImportFileItemBinding

class ImportFilesAdapter : RecyclerView.Adapter<ImportFilesAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: (ImportFileItemBinding)) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            ImportFileItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = 14
}
