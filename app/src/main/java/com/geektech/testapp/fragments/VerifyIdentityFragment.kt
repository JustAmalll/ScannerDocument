package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentVerifyIdentityBinding

class VerifyIdentityFragment : Fragment() {

    private var _binding: FragmentVerifyIdentityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerifyIdentityBinding.inflate(inflater, container, false)

        val lightGray = ContextCompat.getColor(requireContext(), R.color.light_grey)

        binding.OTPView.itemRadius = 24
        binding.OTPView.itemSpacing = 20
        binding.OTPView.setLineColor(lightGray)
        binding.OTPView.setHideLineWhenFilled(false)
        binding.OTPView.setAnimationEnable(true)

        binding.OTPView.addTextChangedListener { charSequence ->
            if (charSequence?.length == 6) {
                findNavController().navigate(R.id.action_verifyIdentityFragment_to_homeFragment)
            }
        }

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
