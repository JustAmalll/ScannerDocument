package com.geektech.testapp.fragments

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentOcrBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class OcrFragment : Fragment() {

    private var _binding: FragmentOcrBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOcrBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.bottomNavView.setupWithNavController(findNavController())

        Dialog(requireContext(), R.style.RoundedCornersDialog).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCancelable(true)
            setContentView(R.layout.dialog_progress_bar_scan)

            val progressBar = this.findViewById<ProgressBar>(R.id.progressBar)
            progressBar.max = 100
            val currentProgress = 100

            ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
                .setDuration(2000)
                .start()

            Handler(Looper.myLooper()!!).postDelayed({
                hide()
                Dialog(requireContext(), R.style.RoundedCornersDialog).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.dialog_touch_swipe_text)
                    this.findViewById<Button>(R.id.okButton).setOnClickListener {
                        hide()
                    }
                    show()
                }
            }, 2000)

            show()
        }

        binding.selectAllButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.ocr_bottom_sheet, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
