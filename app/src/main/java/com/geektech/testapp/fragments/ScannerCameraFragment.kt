package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.view.View
import com.geektech.testapp.R
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentScannerCameraBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ScannerCameraFragment : BaseEmptyFragment<FragmentScannerCameraBinding>(
    FragmentScannerCameraBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun setupClickListener() = with(binding) {
        moreButton.setOnClickListener {
            toolsToolBar.visibility = View.VISIBLE
            smallToolBar.visibility = View.GONE
        }
        moreActiveButton.setOnClickListener {
            toolsToolBar.visibility = View.GONE
            smallToolBar.visibility = View.VISIBLE
        }
        screenOrientationButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(
                R.layout.rotation_type_bottom_sheet, null
            )
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }
        gridButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(
                R.layout.sheet_expansion_screens, null
            )
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }
        autoFlashButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(
                R.layout.flashlight_mode_bottom_sheet, null
            )
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }
        autoFlashButton2.setOnClickListener {
            val dialogView = layoutInflater.inflate(
                R.layout.flashlight_mode_bottom_sheet, null
            )
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }
    }
}
