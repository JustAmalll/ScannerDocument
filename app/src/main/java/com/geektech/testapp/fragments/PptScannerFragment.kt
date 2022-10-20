package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentPptScannerBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class PptScannerFragment : Fragment() {

    private var _binding: FragmentPptScannerBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPptScannerBinding.inflate(inflater, container, false)

        binding.photoOnIdTextView.setOnClickListener {
            findNavController().navigate(R.id.action_pptScannerFragment_to_photoOnIdFragment)
        }

        binding.textRecognitionTextView.setOnClickListener {
            findNavController().navigate(R.id.action_pptScannerFragment_to_textRecognitionFragment)
        }

        binding.photoToWordTextView.setOnClickListener {
            findNavController().navigate(R.id.action_pptScannerFragment_to_photoToWordFragment)
        }

        binding.documentsTextView.setOnClickListener {
            findNavController().navigate(R.id.action_pptScannerFragment_to_photoMenuFragment)
        }

        binding.idDocumentTextView.setOnClickListener {
            findNavController().navigate(R.id.action_pptScannerFragment_to_idDocumentFragment)
        }

        binding.questionnaireTextView.setOnClickListener {
            findNavController().navigate(R.id.action_pptScannerFragment_to_questionnaireFragment)
        }

        binding.improvedPortraitTextView.setOnClickListener {
            findNavController().navigate(R.id.action_pptScannerFragment_to_improvedPortraitFragment)
        }

        binding.bookTextView.setOnClickListener {
            findNavController().navigate(R.id.action_pptScannerFragment_to_bookScanFragment)
        }

        binding.moreTextView.setOnClickListener {
            findNavController().navigate(R.id.action_pptScannerFragment_to_moreFragment)
        }

        binding.flashButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.flashlight_mode_bottom_sheet, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
