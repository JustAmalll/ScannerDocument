package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentBookScanBinding

class BookScanFragment : Fragment() {

    private var _binding: FragmentBookScanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookScanBinding.inflate(inflater, container, false)

        binding.startButton.setOnClickListener {
            binding.cardView.visibility = View.GONE
            binding.makePhotoLL.visibility = View.VISIBLE
            binding.constraintLayout.visibility = View.VISIBLE
        }

        binding.makePhotoButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_bookScanFragment_to_bookScannerMadePhotoFragment
            )
        }

        binding.pptTextView.setOnClickListener {
            findNavController().navigate(R.id.action_bookScanFragment_to_pptScannerFragment)
        }

        binding.photoOnIdTextView.setOnClickListener {
            findNavController().navigate(R.id.action_bookScanFragment_to_photoOnIdFragment)
        }

        binding.textRecognitionTextView.setOnClickListener {
            findNavController().navigate(R.id.action_bookScanFragment_to_textRecognitionFragment)
        }

        binding.photoToWordTextView.setOnClickListener {
            findNavController().navigate(R.id.action_bookScanFragment_to_photoToWordFragment)
        }

        binding.idDocumentTextView.setOnClickListener {
            findNavController().navigate(R.id.action_bookScanFragment_to_idDocumentFragment)
        }

        binding.questionnaireTextView.setOnClickListener {
            findNavController().navigate(R.id.action_bookScanFragment_to_questionnaireFragment)
        }

        binding.improvedPortraitTextView.setOnClickListener {
            findNavController().navigate(R.id.action_bookScanFragment_to_improvedPortraitFragment)
        }

        binding.moreTextView.setOnClickListener {
            findNavController().navigate(R.id.action_bookScanFragment_to_moreFragment)
        }

        binding.documentsTextView.setOnClickListener {
            findNavController().navigate(R.id.action_bookScanFragment_to_documentFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
