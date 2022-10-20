package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentQuestionnaireMadePhotoBinding

class QuestionnaireMadePhotoFragment : Fragment() {

    private var _binding: FragmentQuestionnaireMadePhotoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionnaireMadePhotoBinding.inflate(
            inflater, container, false
        )

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.nextMoveButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_questionnaireMadePhotoFragment_to_questionnaireCheckFragment
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
