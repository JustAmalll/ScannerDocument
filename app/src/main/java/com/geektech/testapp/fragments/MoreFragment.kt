package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)

        binding.makePhotoButton.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_bookScannerMadePhotoFragment)
        }

        binding.pptTextView.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_pptScannerFragment)
        }

        binding.photoOnIdTextView.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_photoOnIdFragment)
        }

        binding.textRecognitionTextView.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_textRecognitionFragment)
        }

        binding.photoToWordTextView.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_photoToWordFragment)
        }

        binding.idDocumentTextView.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_idDocumentFragment)
        }

        binding.questionnaireTextView.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_questionnaireFragment)
        }

        binding.improvedPortraitTextView.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_improvedPortraitFragment)
        }

        binding.bookTextView.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_bookScanFragment)
        }

        binding.nextButton1.setOnClickListener {
            binding.cardView1.visibility = View.GONE
            binding.cardView2.visibility = View.VISIBLE
        }

        binding.nextButton2.setOnClickListener {
            binding.cardView3.visibility = View.VISIBLE
            binding.cardView2.visibility = View.GONE
        }

        binding.nextButton3.setOnClickListener {
            binding.cardView4.visibility = View.VISIBLE
            binding.cardView3.visibility = View.GONE
        }

        binding.okButton.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_postCardMakePhotoFragment)
        }

        binding.postCardButton.setOnClickListener {
            binding.cardView1.visibility = View.VISIBLE
            binding.choseTypeLL.visibility = View.GONE
        }

        binding.qrCodeButton.setOnClickListener {
            binding.choseTypeLL.visibility = View.GONE
            findNavController().navigate(R.id.action_moreFragment_to_qrCodeScannerFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
