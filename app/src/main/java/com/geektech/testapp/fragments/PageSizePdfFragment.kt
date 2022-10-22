package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentPageSizePdfBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class PageSizePdfFragment : BaseEmptyFragment<FragmentPageSizePdfBinding>(
    FragmentPageSizePdfBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        addButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.sheet_add_page_size, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }
    }
}
