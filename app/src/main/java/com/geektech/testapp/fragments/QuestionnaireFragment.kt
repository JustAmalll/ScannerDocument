package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentQuestionnaireBinding

class QuestionnaireFragment : Fragment() {

    private var _binding: FragmentQuestionnaireBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionnaireBinding.inflate(inflater, container, false)

        binding.pptTextView.setOnClickListener {
            findNavController().navigate(R.id.action_questionnaireFragment_to_pptScannerFragment)
        }

        binding.photoOnIdTextView.setOnClickListener {
            findNavController().navigate(R.id.action_questionnaireFragment_to_photoOnIdFragment)
        }

        binding.photoToWordTextView.setOnClickListener {
            findNavController().navigate(R.id.action_questionnaireFragment_to_photoToWordFragment)
        }

        binding.documentsTextView.setOnClickListener {
            findNavController().navigate(R.id.action_questionnaireFragment_to_documentFragment)
        }

        binding.idDocumentTextView.setOnClickListener {
            findNavController().navigate(R.id.action_questionnaireFragment_to_idDocumentFragment)
        }

        binding.makePhotoButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_questionnaireFragment_to_questionnaireMadePhotoFragment
            )
        }

        binding.improvedPortraitTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_questionnaireFragment_to_improvedPortraitFragment
            )
        }

        binding.bookTextView.setOnClickListener {
            findNavController().navigate(R.id.action_questionnaireFragment_to_bookScanFragment)
        }

        binding.moreTextView.setOnClickListener {
            findNavController().navigate(R.id.action_questionnaireFragment_to_moreFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
