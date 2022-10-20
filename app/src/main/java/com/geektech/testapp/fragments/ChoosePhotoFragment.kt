package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentChoosePhotoBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ChoosePhotoFragment : BaseEmptyFragment<FragmentChoosePhotoBinding>(
    FragmentChoosePhotoBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        arrowDownIcon.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.sort_bottom_sheet, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }
    }
}
