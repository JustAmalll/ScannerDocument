package com.geektech.testapp.fragments

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentAddYourWatermarkBinding

class AddYourWatermarkFragment : BaseEmptyFragment<FragmentAddYourWatermarkBinding>(
    FragmentAddYourWatermarkBinding::inflate
) {

    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        imgFile.setOnClickListener {
            Toast.makeText(context, "imgFile", Toast.LENGTH_SHORT).show()
        }
        imgShare.setOnClickListener {
            Toast.makeText(context, "imgShare", Toast.LENGTH_SHORT).show()
        }
        imgFile.setOnClickListener {
            Toast.makeText(context, "imgMore", Toast.LENGTH_SHORT).show()
        }
    }
}
