package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentPdfToolsBinding

class PdfToolsFragment : Fragment() {

    private var _binding: FragmentPdfToolsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPdfToolsBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.extractPagesButton.setOnClickListener {
            findNavController().navigate(R.id.action_pdfToolsFragment_to_importFileFragment)
        }

        binding.PDFtoWordButton.setOnClickListener {
            findNavController().navigate(R.id.action_pdfToolsFragment_to_PDFtoWordFragment)
        }

        binding.PDFtoExcel.setOnClickListener {
            findNavController().navigate(R.id.action_pdfToolsFragment_to_PDFtoWordFragment)
        }

        binding.PDFtoPPT.setOnClickListener {
            findNavController().navigate(R.id.action_pdfToolsFragment_to_PDFtoWordFragment)
        }

        binding.PDFtoJPG.setOnClickListener {
            findNavController().navigate(R.id.action_pdfToolsFragment_to_PDFtoWordFragment)
        }

        binding.PDFtoLongImage.setOnClickListener {
            findNavController().navigate(R.id.action_pdfToolsFragment_to_PDFtoWordFragment)
        }

        binding.addSignatureButton.setOnClickListener {
            findNavController().navigate(R.id.action_pdfToolsFragment_to_addSignatureFragment)
        }

        binding.addPdfPasswordButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_pdfToolsFragment_to_selectFileForPasswordFragment
            )
        }

        binding.fileSettingsButton.setOnClickListener {
            findNavController().navigate(R.id.action_pdfToolsFragment_to_importFileFragment)
        }

        binding.compressionButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_pdfToolsFragment_to_selectFilesForCompressFragment
            )
        }

        binding.waterMarkToPDF.setOnClickListener {
            findNavController().navigate(
                R.id.action_pdfToolsFragment_to_selectFileForWaterMarkFragment
            )
        }

        binding.mergeFilesButton.setOnClickListener {
            findNavController().navigate(R.id.action_pdfToolsFragment_to_importFileFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
