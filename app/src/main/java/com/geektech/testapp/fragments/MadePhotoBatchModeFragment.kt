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
import com.geektech.testapp.databinding.FragmentMadePhotoBatchModeBinding

class MadePhotoBatchModeFragment : Fragment() {

    private var _binding: FragmentMadePhotoBatchModeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMadePhotoBatchModeBinding.inflate(
            inflater, container, false
        )

        binding.icRefresh.setOnClickListener {
            val dialog = Dialog(requireContext(), R.style.RoundedCornersDialog)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.exit_alert_dialog)
            val okTextView = dialog.findViewById(R.id.okTextView) as TextView
            val cancelTextView = dialog.findViewById(R.id.cancelTextView) as TextView
            okTextView.setOnClickListener {
                dialog.hide()
            }
            cancelTextView.setOnClickListener {
                dialog.hide()
            }
            dialog.show()
        }

        binding.makePhotoButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_madePhotoBatchModeFragment_to_enterPhotoFragment
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
