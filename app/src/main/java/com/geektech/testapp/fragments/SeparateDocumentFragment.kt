package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.geektech.testapp.R
import com.geektech.testapp.adapters.SeparateDocumentAdapter
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentSeparateDocumentBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class SeparateDocumentFragment : BaseEmptyFragment<FragmentSeparateDocumentBinding>(
    FragmentSeparateDocumentBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        separateDocumentRv.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = SeparateDocumentAdapter()
        }
        pdfButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_separateDocumentFragment_to_separateDocumentPdfFragment
            )
        }
        shareButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_separateDocumentFragment_to_shareFileFragment
            )
        }
        moreIcon.setOnClickListener {
            val dialogView = layoutInflater.inflate(
                R.layout.separate_document_more_bottom_sheet, null
            )
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }
    }
}
