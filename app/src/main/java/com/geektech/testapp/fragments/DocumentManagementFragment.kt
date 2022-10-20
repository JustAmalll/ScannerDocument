package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentDocumentManagementBinding

class DocumentManagementFragment : Fragment() {

    private var _binding: FragmentDocumentManagementBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDocumentManagementBinding.inflate(
            inflater, container, false
        )

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.tagManagementButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_documentManagementFragment_to_addNewTagFragment
            )
        }

        binding.templateNameLL.setOnClickListener {
            findNavController().navigate(
                R.id.action_documentManagementFragment_to_autoNameTemplateFragment
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
