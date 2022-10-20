package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentRecognizeEditingBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class RecognizeEditingFragment : BaseEmptyFragment<FragmentRecognizeEditingBinding>(
    FragmentRecognizeEditingBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        colorFilterSettingsButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_recognizeEditingFragment_to_editColorFiltersFragment
            )
        }
        labelButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.sheet_text_spot, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.findViewById<LinearLayout>(R.id.addTextButton)?.setOnClickListener {
                dialog.hide()
                val bottomSheetDialogView = layoutInflater.inflate(
                    R.layout.sheet_add_text, null
                )
                dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
                dialog.setContentView(bottomSheetDialogView)
                dialog.findViewById<TextView>(R.id.btnAdd)?.setOnClickListener {
                    dialog.hide()
                    findNavController().navigate(
                        R.id.action_recognizeEditingFragment_to_addTextAnywhereFragment
                    )
                }
                dialog.show()
            }
            dialog.findViewById<LinearLayout>(R.id.spotButton)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(R.id.action_recognizeEditingFragment_to_spotFragment)
            }
            dialog.show()
        }
        toTextButton.setOnClickListener {
            Dialog(requireContext(), R.style.RoundedCornersDialog).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.dialog_language_true_scan)
                this.findViewById<TextView>(R.id.settingsButton).setOnClickListener {
                    hide()
                    findNavController().navigate(
                        R.id.action_recognizeEditingFragment_to_selectedLanguageFragment
                    )
                }
                show()
            }
        }
        addSignatureButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_recognizeEditingFragment_to_addSignatureFragment
            )
        }
    }
}
