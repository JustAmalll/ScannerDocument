package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
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
            dialog.apply {
                setContentView(dialogView)
                findViewById<TextView>(R.id.importImageButton)?.setOnClickListener {
                    hide()
                    findNavController().navigate(
                        R.id.action_separateDocumentFragment_to_selectFileFragment
                    )
                }
                findViewById<ConstraintLayout>(R.id.collageButton)?.setOnClickListener {
                    hide()
                    findNavController().navigate(
                        R.id.action_separateDocumentFragment_to_bulkCollageFragment
                    )
                }
                findViewById<ConstraintLayout>(R.id.convertToWordButton)?.setOnClickListener {
                    hide()
                    findNavController().navigate(
                        R.id.action_separateDocumentFragment_to_wordDocumentPageFragment
                    )
                }
                findViewById<ConstraintLayout>(
                    R.id.counterfeitProtectionButton
                )?.setOnClickListener {
                    hide()
                    findNavController().navigate(
                        R.id.action_separateDocumentFragment_to_separateDocumentPdfFragment
                    )
                }
                findViewById<TextView>(R.id.saveToGalleryButton)?.setOnClickListener {
                    hide()
                    Toast.makeText(
                        requireContext(),
                        "Успешно сохранено в галерее!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                findViewById<TextView>(R.id.batchButton)?.setOnClickListener {
                    hide()
                    findNavController().navigate(
                        R.id.action_separateDocumentFragment_to_bulkEditingFragment
                    )
                }
                findViewById<TextView>(R.id.sendToPcButton)?.setOnClickListener {
                    hide()
                    findNavController().navigate(
                        R.id.action_separateDocumentFragment_to_shareLinkFragment
                    )
                }
                findViewById<TextView>(R.id.renameTextView)?.setOnClickListener {
                    hide()
                    val renameDialogView = layoutInflater.inflate(
                        R.layout.fragment_rename_overlay, null
                    )
                    dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
                    dialog.apply {
                        setContentView(renameDialogView)
                        findViewById<TextView>(R.id.importImageButton)?.setOnClickListener {
                            hide()
                            findNavController().navigate(
                                R.id.action_separateDocumentFragment_to_selectFileFragment
                            )
                        }
                        show()
                    }
                }
                findViewById<TextView>(R.id.selectButton)?.setOnClickListener {
                    hide()
                    findNavController().navigate(
                        R.id.action_separateDocumentFragment_to_bulkEditingFragment
                    )
                }
                findViewById<LinearLayout>(R.id.textRecognitionButton)?.setOnClickListener {
                    hide()
                    findNavController().navigate(
                        R.id.action_separateDocumentFragment_to_ocrFragment
                    )
                }
                findViewById<TextView>(R.id.pdfParamsButton)?.setOnClickListener {
                    hide()
                    findNavController().navigate(
                        R.id.action_separateDocumentFragment_to_optionPdfFragment
                    )
                }
                show()
            }
        }
    }
}
