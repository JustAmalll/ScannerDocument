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

        if (
            findNavController().previousBackStackEntry?.destination?.id ==
            R.id.bulkCollageFragment
        ) showAddWaterMarkBottomSheet()

        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        editButton.setOnClickListener {
            val renameDialogView = layoutInflater.inflate(
                R.layout.rename_page_name_bottom_sheet, null
            )
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.apply {
                setContentView(renameDialogView)
                show()
            }
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
            showAddWaterMarkBottomSheet()
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
                R.id.action_separateDocumentPdfFragment_to_wordDocumentPageFragment
            )
        }
    }

    @SuppressLint("InflateParams")
    private fun showAddWaterMarkBottomSheet() {
        val dialogView = layoutInflater.inflate(R.layout.sheet_add_watermark, null)
        dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        dialog.apply {
            setContentView(dialogView)
            findViewById<TextView>(R.id.cancelButton)?.setOnClickListener {
                hide()
            }
            findViewById<Button>(R.id.btnAdd)?.setOnClickListener {
                hide()
            }
            show()
        }
    }
}
