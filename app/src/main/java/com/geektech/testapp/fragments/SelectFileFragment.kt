package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.geektech.testapp.R
import com.geektech.testapp.adapters.SelectDocumentAdapter
import com.geektech.testapp.databinding.FragmentSelectFileBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class SelectFileFragment : Fragment() {

    private var _binding: FragmentSelectFileBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectFileBinding.inflate(inflater, container, false)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = SelectDocumentAdapter()
        }

        binding.dropDownButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.sort_bottom_sheet, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }

        binding.importButton.setOnClickListener {
            findNavController().navigate(R.id.action_selectFileFragment_to_openPhotoFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
