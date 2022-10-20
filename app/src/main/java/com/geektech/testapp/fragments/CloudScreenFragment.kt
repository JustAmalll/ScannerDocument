package com.geektech.testapp.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.databinding.FragmentCloudScreenBinding

class CloudScreenFragment : Fragment() {

    private var _binding: FragmentCloudScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCloudScreenBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.progressBar.max = 300
        val currentProgress = 200

        ObjectAnimator.ofInt(binding.progressBar, "progress", currentProgress)
            .setDuration(2000)
            .start()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
