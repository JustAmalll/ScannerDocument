package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentChooseEverythingBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MoveToFragment : Fragment() {

    private var _binding: FragmentChooseEverythingBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseEverythingBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.moveButton.setOnClickListener {
        }

        binding.ivAddFolder.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.fragment_rename_overlay, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.findViewById<Button>(R.id.renameButton)?.setOnClickListener {
                findNavController().navigate(
                    R.id.action_moveToFragment_to_customTemplateNameFragment
                )
                dialog.hide()
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
