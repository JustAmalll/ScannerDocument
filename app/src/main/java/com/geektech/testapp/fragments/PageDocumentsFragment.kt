package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentPageDocumentsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class PageDocumentsFragment : BaseEmptyFragment<FragmentPageDocumentsBinding>(
    FragmentPageDocumentsBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        cropButton.setOnClickListener {
            findNavController().navigate(R.id.action_pageDocumentsFragment_to_recognizeFragment)
        }
        OcrButton.setOnClickListener {
            Dialog(requireContext(), R.style.RoundedCornersDialog).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.dialog_language_true_scan)
                this.findViewById<TextView>(R.id.settingsButton)?.setOnClickListener {
                    hide()
                    findNavController().navigate(R.id.action_pageDocumentsFragment_to_ocrFragment)
                }
                show()
            }
        }
        addSignatureButton.setOnClickListener {
            findNavController().navigate(R.id.action_pageDocumentsFragment_to_addSignatureFragment)
        }
        wordDocumentPageButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_pageDocumentsFragment_to_wordDocumentPageFragment
            )
        }
        moreButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(
                R.layout.sheet_save_again_edit_delete, null
            )
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.findViewById<LinearLayout>(R.id.takeAgainButton)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(R.id.action_pageDocumentsFragment_to_documentFragment)
            }
            dialog.findViewById<LinearLayout>(R.id.saveToGalleryButton)?.setOnClickListener {
                dialog.hide()
                Toast.makeText(
                    requireContext(),
                    "Успешно сохранено в галерее!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            dialog.findViewById<LinearLayout>(R.id.editButton)?.setOnClickListener {
                dialog.hide()
                showRenameDialog()
            }
            dialog.findViewById<LinearLayout>(R.id.deleteButton)?.setOnClickListener {
                dialog.hide()
                Toast.makeText(
                    requireContext(),
                    "Файл успешно удален!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            dialog.show()
        }
        binding.addNoteButton.setOnClickListener {
            val bottomSheetView = layoutInflater.inflate(R.layout.add_note_bottom_sheet, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(bottomSheetView)
            dialog.show()
        }
        binding.labelButton.setOnClickListener {
            val bottomSheetView = layoutInflater.inflate(R.layout.label_bottom_sheet, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(bottomSheetView)
            dialog.findViewById<LinearLayout>(R.id.addtextButton)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(
                    R.id.action_pageDocumentsFragment_to_addTextAnywhereFragment
                )
            }
            dialog.findViewById<LinearLayout>(R.id.spotButton)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(R.id.action_pageDocumentsFragment_to_spotFragment)
            }
            dialog.show()
        }
        shareButton.setOnClickListener {
            findNavController().navigate(R.id.action_pageDocumentsFragment_to_shareFileFragment)
        }
        editButton.setOnClickListener {
            showRenameDialog()
        }
    }

    private fun showRenameDialog() {
        val bottomSheetView = layoutInflater.inflate(R.layout.rename_page_name_bottom_sheet, null)
        dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        dialog.setContentView(bottomSheetView)
        dialog.show()
    }
}
