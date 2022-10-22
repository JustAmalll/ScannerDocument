package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentDocumentBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class DocumentFragment : Fragment() {

    private var _binding: FragmentDocumentBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDocumentBinding.inflate(inflater, container, false)

        if (findNavController().previousBackStackEntry?.destination?.id ==
            R.id.pageDocumentsFragment
        ) {
            binding.importFilesLl.visibility = View.INVISIBLE
            binding.batchModeButton.visibility = View.INVISIBLE
        }

        binding.importFilesLl.setOnClickListener {
            findNavController().navigate(R.id.action_documentFragment_to_importFileFragment)
        }

        binding.importPicturesButton.setOnClickListener {
            findNavController().navigate(R.id.action_photoMenuFragment_to_selectFileFragment)
        }

        binding.batchModeButton.setOnClickListener {
            findNavController().navigate(R.id.action_photoMenuFragment_to_batchModeFragment)
        }

        binding.pptTextView.setOnClickListener {
            findNavController().navigate(R.id.action_photoMenuFragment_to_pptScannerFragment)
        }

        binding.photoOnIdTextView.setOnClickListener {
            findNavController().navigate(R.id.action_photoMenuFragment_to_photoOnIdFragment)
        }

        binding.textRecognitionTextView.setOnClickListener {
            findNavController().navigate(R.id.action_photoMenuFragment_to_textRecognitionFragment)
        }

        binding.photoToWordTextView.setOnClickListener {
            findNavController().navigate(R.id.action_photoMenuFragment_to_photoToWordFragment)
        }

        binding.idDocumentTextView.setOnClickListener {
            findNavController().navigate(R.id.action_documentFragment_to_idDocumentFragment)
        }

        binding.questionnaireTextView.setOnClickListener {
            findNavController().navigate(R.id.action_documentFragment_to_questionnaireFragment)
        }

        binding.improvedPortraitTextView.setOnClickListener {
            findNavController().navigate(R.id.action_documentFragment_to_improvedPortraitFragment)
        }

        binding.bookTextView.setOnClickListener {
            findNavController().navigate(R.id.action_documentFragment_to_bookScanFragment)
        }

        binding.moreTextView.setOnClickListener {
            findNavController().navigate(R.id.action_documentFragment_to_moreFragment)
        }

        binding.flashButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.flashlight_mode_bottom_sheet, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }

        binding.hdButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.sheet_expansion_screens, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }

        binding.smallToolBarMoreIcon.setOnClickListener {
            if (binding.toolBarMore.visibility == View.VISIBLE) {
                binding.toolBarMore.visibility = View.GONE
                binding.smallToolBarMoreIcon.setColorFilter(
                    ContextCompat.getColor(requireContext(), R.color.white),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
            } else {
                binding.toolBarMore.visibility = View.VISIBLE
                binding.smallToolBarMoreIcon.setColorFilter(
                    ContextCompat.getColor(requireContext(), R.color.primary),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
            }
        }

        var isSoundOnDisplayed = true

        binding.icSoundOn.setOnClickListener {
            isSoundOnDisplayed = if (isSoundOnDisplayed) {
                binding.icSoundOn.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_sound_off)
                )
                false
            } else {
                binding.icSoundOn.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_sound_on)
                )
                true
            }
        }

        binding.autoRotateIcon.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.rotation_type_bottom_sheet, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }

        binding.shutterIcon.setOnClickListener {
            isSoundOnDisplayed = if (isSoundOnDisplayed) {
                binding.shutterIcon.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_shutter_off)
                )
                false
            } else {
                binding.shutterIcon.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_auto_shutter)
                )
                true
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
