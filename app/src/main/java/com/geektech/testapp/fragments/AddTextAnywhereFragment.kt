package com.geektech.testapp.fragments

import androidx.navigation.fragment.findNavController
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentAddTextAnywhereBinding

class AddTextAnywhereFragment : BaseEmptyFragment<FragmentAddTextAnywhereBinding>(
    FragmentAddTextAnywhereBinding::inflate
) {

    override fun setupClickListener() = with(binding) {
        btnToolbarSave.setOnClickListener {
            findNavController().popBackStack()
        }
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
