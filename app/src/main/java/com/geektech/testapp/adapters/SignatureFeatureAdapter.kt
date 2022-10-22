package com.geektech.testapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.geektech.testapp.databinding.ItemAddSignatureBinding

class SignatureFeatureAdapter : RecyclerView.Adapter<SignatureFeatureAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: (ItemAddSignatureBinding)) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            ItemAddSignatureBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.container.setOnClickListener {
            it.findNavController().popBackStack()
        }
    }

    override fun getItemCount(): Int = 4
}
