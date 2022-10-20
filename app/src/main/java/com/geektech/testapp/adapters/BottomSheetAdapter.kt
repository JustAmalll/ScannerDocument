package com.geektech.testapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.testapp.databinding.PhoneNumberItemBinding

class BottomSheetAdapter : RecyclerView.Adapter<BottomSheetAdapter.BottomSheetViewHolder>() {

    class BottomSheetViewHolder(val binding: PhoneNumberItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetViewHolder =
        BottomSheetViewHolder(
            PhoneNumberItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: BottomSheetViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = 10
}
