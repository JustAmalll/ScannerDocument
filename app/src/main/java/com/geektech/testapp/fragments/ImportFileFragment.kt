package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.testapp.R
import com.geektech.testapp.adapters.ImportFilesAdapter
import com.geektech.testapp.databinding.FragmentImportFileBinding

class ImportFileFragment : Fragment() {

    private var _binding: FragmentImportFileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImportFileBinding.inflate(inflater, container, false)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ImportFilesAdapter()
        }

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.importButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_importFileFragment_to_separateDocumentFragment
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
