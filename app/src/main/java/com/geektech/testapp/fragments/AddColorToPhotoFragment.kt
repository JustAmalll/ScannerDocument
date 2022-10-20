package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentAddColorToPhotoBinding

class AddColorToPhotoFragment : Fragment() {

    private var _binding: FragmentAddColorToPhotoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddColorToPhotoBinding.inflate(
            inflater, container, false
        )

        binding.improveTv.setOnClickListener {
            findNavController().navigate(
                R.id.action_addColorToPhotoFragment_to_improvedPortraitFragment
            )
        }

        binding.seeTemplateTv.setOnClickListener {
            findNavController().navigate(
                R.id.action_addColorToPhotoFragment_to_addColorToPhotoExamplesFragment
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
