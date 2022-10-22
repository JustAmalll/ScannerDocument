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
import com.geektech.testapp.databinding.FragmentShareFileMethodsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ShareFileFragment : Fragment() {

    private var _binding: FragmentShareFileMethodsBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShareFileMethodsBinding.inflate(inflater, container, false)

        val dialogView = layoutInflater.inflate(R.layout.fragment_file_details_overlay, null)
        dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        dialog.setContentView(dialogView)
        dialog.findViewById<Button>(R.id.shareButton)?.setOnClickListener {
            dialog.hide()
        }
        dialog.findViewById<Button>(R.id.deleteWaterMarkButton)?.setOnClickListener {
            dialog.hide()
        }
        dialog.show()

        binding.sharePdfTextView.setOnClickListener {
            val minimizeSizeFragment = layoutInflater.inflate(
                R.layout.fragment_minimize_size, null
            )
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(minimizeSizeFragment)
            dialog.show()
        }

        binding.shareWordTextView.setOnClickListener {
            val fragmentShareWordDialog = layoutInflater.inflate(
                R.layout.fragment_share_word, null
            )
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(fragmentShareWordDialog)
            dialog.show()
        }

        binding.shareLongImageTextView.setOnClickListener {
            findNavController().navigate(R.id.action_shareFileFragment_to_fragmentShareBigImage)
        }

        binding.tvShareLink.setOnClickListener {
            findNavController().navigate(R.id.action_shareFileFragment_to_shareLinkFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
