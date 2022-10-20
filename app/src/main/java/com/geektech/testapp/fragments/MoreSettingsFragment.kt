package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentMoreSettingsBinding

class MoreSettingsFragment : Fragment() {

    private var _binding: FragmentMoreSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreSettingsBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.freeUpMemoryLL.setOnClickListener {
            findNavController().navigate(R.id.action_moreSettingsFragment_to_freeUpMemoryFragment)
        }

        binding.permissionManagerLL.setOnClickListener {
            findNavController().navigate(
                R.id.action_moreSettingsFragment_to_permissionManagerFragment
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
