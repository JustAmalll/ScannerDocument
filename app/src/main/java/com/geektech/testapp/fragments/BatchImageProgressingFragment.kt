package com.geektech.testapp.fragments

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentBatchImageProcessingBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BatchImageProgressingFragment : BaseEmptyFragment<FragmentBatchImageProcessingBinding>(
    FragmentBatchImageProcessingBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        cropButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_batchImageProgressingFragment_to_cuttingProgressingFragment
            )
        }
        filterButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.sheet_bulk_images, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }
        saveButton.setOnClickListener {
            showLoadingDialog()
        }
    }

    private fun showLoadingDialog() {
        val loadingDialog = Dialog(requireContext(), R.style.RoundedCornersDialog)
        loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loadingDialog.setCancelable(false)
        loadingDialog.setContentView(R.layout.loading_dialog)
        loadingDialog.findViewById<TextView>(R.id.statusTextView).visibility = View.GONE
        loadingDialog.show()

        val progressBar = loadingDialog.findViewById<ProgressBar>(R.id.progressBar)
        progressBar.max = 100
        val currentProgress = 100

        ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
            .setDuration(2000)
            .start()

        Handler(Looper.myLooper()!!).postDelayed({
            findNavController().navigate(
                R.id.action_batchImageProgressingFragment_to_bulkCollageFragment
            )
            loadingDialog.hide()
        }, 2000)
    }
}
