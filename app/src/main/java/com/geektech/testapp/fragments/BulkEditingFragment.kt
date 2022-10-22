package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
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

    @SuppressLint("InflateParams")
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
        deleteButton.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Успешно удалено!",
                Toast.LENGTH_SHORT
            ).show()
        }
        moveToButton.setOnClickListener {
            findNavController().navigate(R.id.action_bulkEditingFragment_to_moveToFragment)
        }
        saveToGalleryButton.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Успешно сохранено в галлерею!",
                Toast.LENGTH_SHORT
            ).show()
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
            dialog.findViewById<TextView>(R.id.copyTv)?.setOnClickListener {
                dialog.hide()
                Toast.makeText(
                    requireContext(),
                    "Успешно скопировано!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            dialog.findViewById<TextView>(R.id.loadTextView)?.setOnClickListener {
                dialog.hide()
                Toast.makeText(
                    requireContext(),
                    "Загрузка",
                    Toast.LENGTH_SHORT
                ).show()
            }
            dialog.findViewById<LinearLayout>(R.id.collageLL)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(
                    R.id.action_bulkEditingFragment_to_bulkCollageFragment
                )
            }
            dialog.show()
        }
    }
}
