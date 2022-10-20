package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geektech.testapp.databinding.FragmentEnterPhotoBinding

class EnterPhotoFragment : Fragment() {

    private var _binding: FragmentEnterPhotoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnterPhotoBinding.inflate(inflater, container, false)

        binding.filterItem.setOnClickListener {
            binding.mainBottomView.visibility = View.GONE
            binding.filterBottomView.visibility = View.VISIBLE
            binding.cropBottomView.visibility = View.GONE
        }

        binding.cropItem.setOnClickListener {
            binding.mainBottomView.visibility = View.GONE
            binding.filterBottomView.visibility = View.GONE
            binding.cropBottomView.visibility = View.VISIBLE
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
