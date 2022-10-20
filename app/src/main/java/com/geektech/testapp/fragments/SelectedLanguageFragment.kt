package com.geektech.testapp.fragments

import androidx.navigation.fragment.findNavController
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentSelectedLanguageBinding

class SelectedLanguageFragment : BaseEmptyFragment<FragmentSelectedLanguageBinding>(
    FragmentSelectedLanguageBinding::inflate
) {

    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        applyButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
