package com.geektech.testapp.fragments

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.testapp.adapters.SignatureFeatureAdapter
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentSignatureFeaturesBinding

class SignatureFeaturesFragment : BaseEmptyFragment<FragmentSignatureFeaturesBinding>(
    FragmentSignatureFeaturesBinding::inflate
) {

    override fun setupClickListener() = with(binding) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = SignatureFeatureAdapter()
        }
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
