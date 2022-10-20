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
import com.geektech.testapp.databinding.FragmentSynchronizeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class SynchronizeFragment : Fragment() {

    private var _binding: FragmentSynchronizeBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSynchronizeBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.autoSyncLL.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.auto_sync_bottom_sheet, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }

        binding.syncButton.setOnClickListener {
            Dialog(requireContext(), R.style.RoundedCornersDialog).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.backup_dialog)
                this.findViewById<TextView>(R.id.okTextView)?.setOnClickListener {
                    hide()
                }
                show()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
