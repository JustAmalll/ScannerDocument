package com.geektech.testapp.fragments

import android.app.Dialog
import android.view.Window
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.geektech.testapp.R
import com.geektech.testapp.adapters.MassiveEditingAdapter
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentBulkEditingBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BulkEditingFragment : BaseEmptyFragment<FragmentBulkEditingBinding>(
    FragmentBulkEditingBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog

    override fun setupClickListener() = with(binding) {
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        shareButton.setOnClickListener {
            findNavController().navigate(R.id.action_bulkEditingFragment_to_shareFileFragment)
        }
        recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = MassiveEditingAdapter()
        }
        emptySpace.setOnClickListener {
            findNavController().navigate(R.id.action_bulkEditingFragment_to_pageDocumentsFragment)
        }
        moreButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.sheet_editing_bulk, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.findViewById<TextView>(R.id.batchButton)?.setOnClickListener {
                dialog.hide()
                Dialog(requireContext(), R.style.RoundedCornersDialog).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.dialog_bulk_editing)
                    this.findViewById<TextView>(R.id.yesButton)?.setOnClickListener {
                        findNavController().navigate(
                            R.id.action_bulkEditingFragment_to_batchImageProgressingFragment
                        )
                        hide()
                    }
                    show()
                }
            }
            dialog.show()
        }
    }
}
