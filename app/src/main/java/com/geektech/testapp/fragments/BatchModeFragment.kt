package com.geektech.testapp.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentBatchModeBinding

class BatchModeFragment : Fragment() {

    private var _binding: FragmentBatchModeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBatchModeBinding.inflate(inflater, container, false)

        binding.continueButton.setOnClickListener {
            val dialog = Dialog(requireContext(), R.style.RoundedCornersDialog)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.adjust_crop_range_dialog)
            val okTextView = dialog.findViewById(R.id.okTextView) as TextView
            okTextView.setOnClickListener {
                findNavController().navigate(
                    R.id.action_batchModeFragment_to_madePhotoBatchModeFragment
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
