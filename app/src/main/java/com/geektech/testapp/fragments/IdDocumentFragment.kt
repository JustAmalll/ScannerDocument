package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentIdDocumentBinding

class IdDocumentFragment : Fragment() {

    private var _binding: FragmentIdDocumentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIdDocumentBinding.inflate(inflater, container, false)

        binding.createButton.setOnClickListener {
            binding.makePhotoLL.visibility = View.VISIBLE
            binding.createCardView.visibility = View.GONE
            binding.choseTypeLL.visibility = View.GONE
            binding.image.visibility = View.VISIBLE
        }

        binding.pptTextView.setOnClickListener {
            findNavController().navigate(R.id.action_idDocumentFragment_to_pptScannerFragment)
        }

        binding.photoOnIdTextView.setOnClickListener {
            findNavController().navigate(R.id.action_idDocumentFragment_to_photoOnIdFragment)
        }

        binding.photoToWordTextView.setOnClickListener {
            findNavController().navigate(R.id.action_idDocumentFragment_to_photoToWordFragment)
        }

        binding.documentsTextView.setOnClickListener {
            findNavController().navigate(R.id.action_idDocumentFragment_to_documentFragment)
        }

        binding.textRecognitionTextView.setOnClickListener {
            findNavController().navigate(R.id.action_idDocumentFragment_to_textRecognitionFragment)
        }

        binding.makePhotoButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_idDocumentFragment_to_idDocumentMadePhotoFragment
            )
        }

        binding.questionnaireTextView.setOnClickListener {
            findNavController().navigate(R.id.action_idDocumentFragment_to_questionnaireFragment)
        }

        binding.improvedPortraitTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_idDocumentFragment_to_improvedPortraitFragment
            )
        }

        binding.bookTextView.setOnClickListener {
            findNavController().navigate(R.id.action_idDocumentFragment_to_bookScanFragment)
        }

        binding.moreTextView.setOnClickListener {
            findNavController().navigate(R.id.action_idDocumentFragment_to_moreFragment)
        }

        binding.idCardButton.setOnClickListener {
            binding.cardImageView.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_id_card_big)
            )
        }

        binding.creditCardButton.setOnClickListener {
            binding.cardImageView.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_credit_card)
            )
        }

        binding.passwordButton.setOnClickListener {
            binding.cardImageView.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.passport)
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
