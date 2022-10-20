package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentShareLinkMethodsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ShareLinkFragment : Fragment() {

    private var _binding: FragmentShareLinkMethodsBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShareLinkMethodsBinding.inflate(inflater, container, false)

        binding.tvShareFile.setOnClickListener {
            findNavController().navigate(R.id.action_shareLinkFragment_to_shareFileFragment)
        }

        binding.linkSettingsIv.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.fragment_link_settings, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }

        binding.sendToPcIv.setOnClickListener {
            Dialog(requireContext(), R.style.RoundedCornersDialog).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.dialog_send_to_pc)
                this.findViewById<Button>(R.id.scanButton)?.setOnClickListener {
                    hide()
                    findNavController().navigate(
                        R.id.action_shareLinkFragment_to_qrCodeScannerFragment
                    )
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
