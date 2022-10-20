package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentBookScannerMadePhotoBinding

class BookScannerMadePhotoFragment : Fragment() {

    private var _binding: FragmentBookScannerMadePhotoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookScannerMadePhotoBinding.inflate(
            inflater, container, false
        )

        binding.pptTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_bookScannerMadePhotoFragment_to_pptScannerFragment
            )
        }

        binding.photoOnIdTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_bookScannerMadePhotoFragment_to_photoOnIdFragment
            )
        }

        binding.photoToWordTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_bookScannerMadePhotoFragment_to_photoToWordFragment
            )
        }

        binding.documentsTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_bookScannerMadePhotoFragment_to_documentFragment
            )
        }

        binding.textRecognitionTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_bookScannerMadePhotoFragment_to_textRecognitionFragment
            )
        }

        binding.questionnaireTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_bookScannerMadePhotoFragment_to_questionnaireFragment
            )
        }

        binding.improvedPortraitTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_bookScannerMadePhotoFragment_to_improvedPortraitFragment
            )
        }

        binding.bookTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_bookScannerMadePhotoFragment_to_bookScanFragment
            )
        }

        binding.idDocumentTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_bookScannerMadePhotoFragment_to_idDocumentFragment
            )
        }

        binding.moreTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_bookScannerMadePhotoFragment_to_moreFragment
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
