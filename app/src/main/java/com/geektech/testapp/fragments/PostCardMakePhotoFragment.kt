package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentPostCardMakePhotoBinding

class PostCardMakePhotoFragment : Fragment() {

    private var _binding: FragmentPostCardMakePhotoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostCardMakePhotoBinding.inflate(
            inflater, container, false
        )

        binding.makePhotoButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_postCardMakePhotoFragment_to_postCardMadePhotoFragment
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
