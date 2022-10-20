package com.geektech.testapp.fragments

import androidx.navigation.fragment.findNavController
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentEditsColorFiltersBinding

class EditColorFiltersFragment : BaseEmptyFragment<FragmentEditsColorFiltersBinding>(
    FragmentEditsColorFiltersBinding::inflate
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
