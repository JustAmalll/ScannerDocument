package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.view.Window
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentOptionsPdfBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class OptionPdfFragment : BaseEmptyFragment<FragmentOptionsPdfBinding>(
    FragmentOptionsPdfBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        setPdfPassword.setOnClickListener {
            Dialog(requireContext(), R.style.RoundedCornersDialog).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.dialog_set_password_pdf)
                this.findViewById<TextView>(R.id.cancelButton).setOnClickListener {
                    hide()
                }
                show()
            }
        }
        pdfDirectionButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.sheet_direction_pdf, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }
        pageSizePdfButton.setOnClickListener {
            findNavController().navigate(R.id.action_optionPdfFragment_to_pageSizePdfFragment)
        }
        pdfPageNumberButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_optionPdfFragment_to_numberingOptionsPdfFragment
            )
        }
    }
}
