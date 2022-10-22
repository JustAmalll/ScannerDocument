package com.geektech.testapp.fragments

import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentBulkCollageBinding

class BulkCollageFragment : BaseEmptyFragment<FragmentBulkCollageBinding>(
    FragmentBulkCollageBinding::inflate
) {

    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        sizeButton.setOnClickListener {
            findNavController().navigate(R.id.action_bulkCollageFragment_to_bulkSizeFragment)
        }
        waterMarkButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_bulkCollageFragment_to_separateDocumentPdfFragment
            )
        }
    }
}
