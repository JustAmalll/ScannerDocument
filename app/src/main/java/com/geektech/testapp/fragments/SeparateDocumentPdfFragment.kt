package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentSeparateDocumentPdfBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class SeparateDocumentPdfFragment : BaseEmptyFragment<FragmentSeparateDocumentPdfBinding>(
    FragmentSeparateDocumentPdfBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        shareButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_separateDocumentPdfFragment_to_shareFileFragment
            )
        }
        addSignatureButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_separateDocumentPdfFragment_to_addSignatureFragment
            )
        }
        addWaterMarkButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.sheet_add_watermark, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.findViewById<TextView>(R.id.cancelButton)?.setOnClickListener {
                dialog.hide()
            }
            dialog.findViewById<Button>(R.id.btnAdd)?.setOnClickListener {
                dialog.hide()
            }
            dialog.show()
        }
        pdfSettings.setOnClickListener {
            findNavController().navigate(
                R.id.action_separateDocumentPdfFragment_to_optionPdfFragment
            )
        }
        compressionButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.sheet_file_compression, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }
        convertToWordButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_separateDocumentPdfFragment_to_shareFileFragment
            )
        }
    }
}
