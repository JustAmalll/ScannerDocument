package com.geektech.testapp.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.progressBar.max = 300
        val currentProgress = 200

        ObjectAnimator.ofInt(binding.progressBar, "progress", currentProgress)
            .setDuration(2000)
            .start()

        binding.loginUserView.setOnClickListener {
            binding.viewAfterUserLogin.visibility = View.VISIBLE
            binding.loginUserView.visibility = View.GONE
        }

        binding.userNameLL.setOnClickListener {
            binding.loginUserView.visibility = View.VISIBLE
            binding.viewAfterUserLogin.visibility = View.GONE
        }

        binding.accountLl.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_accountFragment)
        }

        binding.synchronizeLL.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_synchronizeFragment)
        }

        binding.scanLL.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_scanFragment)
        }

        binding.documentManagementLL.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_documentManagementFragment)
        }

        binding.moreSettingsLL.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_moreSettingsFragment)
        }

        binding.recommendLL.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_recommendFragment)
        }

        binding.feedbackLL.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_feedbackFragment)
        }

        binding.moreSpaceTextView.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_freeUpMemoryFragment)
        }

        binding.scanQrCodeButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_qrCodeScannerFragment)
        }

        binding.updatePremiumButton.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Данный функционал еще не доступен!",
                Toast.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
