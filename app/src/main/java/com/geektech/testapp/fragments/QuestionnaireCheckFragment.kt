package com.geektech.testapp.fragments

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentQuestionnaireCheckBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class QuestionnaireCheckFragment : Fragment() {

    private var _binding: FragmentQuestionnaireCheckBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionnaireCheckBinding.inflate(
            inflater, container, false
        )

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.nextMoveButton.setOnClickListener {
            val dialogView =
                layoutInflater.inflate(R.layout.create_questionnaire_bottom_sheet, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.findViewById<TextView>(R.id.createQuestionnaireTextView)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(
                    R.id.action_questionnaireCheckFragment_to_createQuestionnaireFragment
                )
            }
            dialog.findViewById<TextView>(R.id.saveOnlyImageTextView)?.setOnClickListener {
                dialog.hide()
                val newDocumentDialogView =
                    layoutInflater.inflate(R.layout.new_document_name_bottom_sheet, null)
                dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
                dialog.setContentView(newDocumentDialogView)
                dialog.findViewById<Button>(R.id.createButton)?.setOnClickListener {
                    dialog.hide()
                    showLoadingDialog()
                }
                dialog.show()
            }
            dialog.show()
        }

        return binding.root
    }

    private fun showLoadingDialog() {
        val loadingDialog = Dialog(requireContext(), R.style.RoundedCornersDialog)
        loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loadingDialog.setCancelable(false)
        loadingDialog.setContentView(R.layout.loading_dialog)
        loadingDialog.show()

        val progressBar = loadingDialog.findViewById<ProgressBar>(R.id.progressBar)
        progressBar.max = 100
        val currentProgress = 100

        ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
            .setDuration(2000)
            .start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
