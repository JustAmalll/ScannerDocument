package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentImprovedPortraitBinding

class ImprovedPortraitFragment : Fragment() {

    private var _binding: FragmentImprovedPortraitBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImprovedPortraitBinding.inflate(inflater, container, false)

        binding.improveNowButton.setOnClickListener {
            binding.makePhotoLL.visibility = View.VISIBLE
            binding.cardView.visibility = View.GONE
            binding.container.background = ContextCompat.getDrawable(
                requireContext(), R.drawable.image_placeholder
            )
        }

        binding.seeTemplateTv.setOnClickListener {
            findNavController().navigate(
                R.id.action_improvedPortraitFragment_to_improvePortraitTemplateFragment
            )
        }

        binding.pptTextView.setOnClickListener {
            findNavController().navigate(R.id.action_improvedPortraitFragment_to_pptScannerFragment)
        }

        binding.photoOnIdTextView.setOnClickListener {
            findNavController().navigate(R.id.action_improvedPortraitFragment_to_photoOnIdFragment)
        }

        binding.photoToWordTextView.setOnClickListener {
            findNavController().navigate(
                R
                    .id.action_improvedPortraitFragment_to_photoToWordFragment
            )
        }

        binding.documentsTextView.setOnClickListener {
            findNavController().navigate(R.id.action_improvedPortraitFragment_to_documentFragment)
        }

        binding.textRecognitionTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_improvedPortraitFragment_to_textRecognitionFragment
            )
        }

        binding.questionnaireTextView.setOnClickListener {
            findNavController().navigate(
                R.id.action_improvedPortraitFragment_to_questionnaireFragment
            )
        }

        binding.makePhotoButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_improvedPortraitFragment_to_improvedPortraitMadePhotoFragment
            )
        }

        binding.bookTextView.setOnClickListener {
            findNavController().navigate(R.id.action_improvedPortraitFragment_to_bookScanFragment)
        }

        binding.moreTextView.setOnClickListener {
            findNavController().navigate(R.id.action_improvedPortraitFragment_to_moreFragment)
        }

        binding.addColorTv.setOnClickListener {
            findNavController().navigate(
                R.id.action_improvedPortraitFragment_to_addColorToPhotoFragment
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
