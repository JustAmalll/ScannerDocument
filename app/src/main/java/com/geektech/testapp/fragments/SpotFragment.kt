package com.geektech.testapp.fragments

import androidx.navigation.fragment.findNavController
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentSpotBinding

class SpotFragment : BaseEmptyFragment<FragmentSpotBinding>(
    FragmentSpotBinding::inflate
) {

    override fun setupClickListener() = with(binding) {
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
