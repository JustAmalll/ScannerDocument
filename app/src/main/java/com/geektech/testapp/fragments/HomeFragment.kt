package com.geektech.testapp.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.HomeScreenBinding

class HomeFragment : Fragment() {

    private var _binding: HomeScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeScreenBinding.inflate(inflater, container, false)

        binding.progressBar.max = 300
        val currentProgress = 200

        ObjectAnimator.ofInt(binding.progressBar, "progress", currentProgress)
            .setDuration(2000)
            .start()

        binding.scanButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_documentFragment)
        }

        binding.searchButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }

        binding.importPicturesButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_selectFileFragment)
        }

        binding.importFilesButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_importFileFragment)
        }

        binding.scanIdDocumentButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_idDocumentFragment)
        }

        binding.imageToTextButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_textRecognitionFragment)
        }

        binding.improvedPortraitButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_improvedPortraitFragment)
        }

        binding.allButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_toolsFragment)
        }

        binding.pdfToolsButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_pdfToolsFragment)
        }

        binding.smartScanButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_documentFragment)
        }

        binding.moreSpaceButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_freeUpMemoryFragment)
        }

        binding.documentLL.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_pageDocumentsFragment)
        }

        binding.premiumButton.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Данный функционал еще не доступен!",
                Toast.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
