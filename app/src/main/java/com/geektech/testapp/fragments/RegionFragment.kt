package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geektech.testapp.R
import com.geektech.testapp.adapters.BottomSheetAdapter
import com.geektech.testapp.databinding.FragmentRegionBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class RegionFragment : Fragment() {

    private var _binding: FragmentRegionBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegionBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.nextMoveButton.setOnClickListener {
            findNavController().navigate(R.id.action_regionFragment_to_confirmPhoneFragment)
        }

        binding.regionInputLayout.setOnClickListener {
            showBottomSheet()
        }

        return binding.root
    }

    private fun showBottomSheet() {
        val dialogView = layoutInflater.inflate(R.layout.region_bottom_sheet, null)
        val closeDialogButton = dialogView.findViewById<ImageView>(R.id.closeDialogButton)

        val recyclerView = dialogView.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = BottomSheetAdapter()

        closeDialogButton.setOnClickListener {
            dialog.hide()
        }
        dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        dialog.setContentView(dialogView)
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
