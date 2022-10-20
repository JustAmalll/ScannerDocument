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
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentWordPageDocumentBinding

class WordDocumentPageFragment : Fragment() {

    private var _binding: FragmentWordPageDocumentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordPageDocumentBinding.inflate(inflater, container, false)

        binding.progressBar.max = 100
        val currentProgress = 100

        ObjectAnimator.ofInt(binding.progressBar, "progress", currentProgress)
            .setDuration(2000)
            .start()

        Handler(Looper.myLooper()!!).postDelayed({
            binding.progressBar.visibility = View.GONE
            binding.bottomNavLL.visibility = View.VISIBLE
            binding.pageCounterTextView.visibility = View.VISIBLE
            Dialog(requireContext(), R.style.RoundedCornersDialog).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.word_message_dialog)
                this.findViewById<TextView>(R.id.okButton)?.setOnClickListener {
                    hide()
                }
                show()
            }
        }, 2000)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.pageDocumentsButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_wordDocumentPageFragment_to_pageDocumentsFragment
            )
        }

        binding.scanRangeButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_wordDocumentPageFragment_to_wordScanRangeFragment
            )
        }

        binding.translateButton.setOnClickListener {
            findNavController().navigate(R.id.action_wordDocumentPageFragment_to_translateFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
