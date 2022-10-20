package com.geektech.testapp.fragments

import androidx.navigation.fragment.findNavController
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentSignatureFeaturesBinding

class SignatureFeaturesFragment : BaseEmptyFragment<FragmentSignatureFeaturesBinding>(
    FragmentSignatureFeaturesBinding::inflate
) {

    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
