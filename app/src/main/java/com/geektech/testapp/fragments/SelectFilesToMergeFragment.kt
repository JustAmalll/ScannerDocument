package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentSelectFilesToMergeBinding

class SelectFilesToMergeFragment : Fragment() {

    private var _binding: FragmentSelectFilesToMergeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectFilesToMergeBinding.inflate(
            inflater, container, false
        )

        binding.mergeFilesButton.isEnabled = false

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.itemsLL.setOnClickListener {
            binding.mergeFilesButton.isEnabled = true
        }

        binding.mergeFilesButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_selectFilesToMergeFragment_to_mergeFilesFragment
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
