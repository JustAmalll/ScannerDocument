package com.geektech.testapp.fragments

import android.animation.ObjectAnimator
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentRecognizeBinding

class RecognizeFragment : BaseEmptyFragment<FragmentRecognizeBinding>(
    FragmentRecognizeBinding::inflate
) {

    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            findNavController().popBackStack()
        }
        nextMoveButton.setOnClickListener {
            progressBar.visibility = View.VISIBLE

            progressBar.max = 100
            val currentProgress = 100

            ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
                .setDuration(2000)
                .start()

            Handler(Looper.myLooper()!!).postDelayed({
                findNavController().navigate(
                    R.id.action_recognizeFragment_to_recognizeEditingFragment
                )
            }, 2000)
        }
    }
}
