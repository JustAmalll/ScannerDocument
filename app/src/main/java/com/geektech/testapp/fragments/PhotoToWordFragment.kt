package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentPhotoToWordBinding

class PhotoToWordFragment : Fragment() {

    private var _binding: FragmentPhotoToWordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoToWordBinding.inflate(inflater, container, false)

        binding.pptTextView.setOnClickListener {
            findNavController().navigate(R.id.action_photoToWordFragment_to_pptScannerFragment)
        }

        binding.photoOnIdTextView.setOnClickListener {
            findNavController().navigate(R.id.action_photoToWordFragment_to_photoOnIdFragment)
        }

        binding.textRecognitionTextView.setOnClickListener {
            findNavController().navigate(R.id.action_photoToWordFragment_to_textRecognitionFragment)
        }

        binding.documentsTextView.setOnClickListener {
            findNavController().navigate(R.id.action_photoToWordFragment_to_photoMenuFragment)
        }

        binding.idDocumentTextView.setOnClickListener {
            findNavController().navigate(R.id.action_photoToWordFragment_to_idDocumentFragment)
        }

        binding.questionnaireTextView.setOnClickListener {
            findNavController().navigate(R.id.action_photoToWordFragment_to_questionnaireFragment)
        }

        binding.bookTextView.setOnClickListener {
            findNavController().navigate(R.id.action_photoToWordFragment_to_bookScanFragment)
        }

        binding.moreTextView.setOnClickListener {
            findNavController().navigate(R.id.action_photoToWordFragment_to_moreFragment)
        }

        binding.startDetectButton.setOnClickListener {
            binding.cardView.visibility = View.GONE
            binding.container.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.image_placeholder)
            binding.makePhotoLL.visibility = View.VISIBLE
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
