package com.geektech.testapp.fragments

import android.animation.ObjectAnimator
import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentSelectFilesForCompressBinding

class SelectFilesForCompressFragment : Fragment() {

    private var _binding: FragmentSelectFilesForCompressBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectFilesForCompressBinding.inflate(
            inflater, container, false
        )

        binding.itemsLL.setOnClickListener {
            val loadingDialog = Dialog(requireContext(), R.style.RoundedCornersDialog)
            loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            loadingDialog.setCancelable(false)
            loadingDialog.setContentView(R.layout.loading_dialog)
            loadingDialog.show()

            val progressBar = loadingDialog.findViewById<ProgressBar>(R.id.progressBar)
            progressBar.max = 100
            val currentProgress = 100

            ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
                .setDuration(2000)
                .start()

            Handler(Looper.myLooper()!!).postDelayed({
                findNavController().navigate(
                    R.id.action_selectFilesForCompressFragment_to_compressionDoneFragment
                )
                loadingDialog.hide()
            }, 2000)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
