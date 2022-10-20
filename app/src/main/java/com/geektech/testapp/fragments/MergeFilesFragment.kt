package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentSortDocumentsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MergeFilesFragment : Fragment() {

    private var _binding: FragmentSortDocumentsBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSortDocumentsBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btReady.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.fragment_merge_methods, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialogView.findViewById<TextView>(R.id.tv_merge_and_save_old)?.setOnClickListener {
                dialog.hide()
                val mergeDialogView =
                    layoutInflater.inflate(R.layout.fragment_files_merge_menu, null)
                dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
                dialog.setContentView(mergeDialogView)
                dialog.show()
            }
            dialog.show()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
