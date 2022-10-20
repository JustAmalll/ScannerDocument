package com.geektech.testapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentToolsBinding

class ToolsFragment : Fragment() {

    private var _binding: FragmentToolsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToolsBinding.inflate(inflater, container, false)

        binding.PDFtoWordButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_PDFtoWordFragment)
        }

        binding.PDFtoExcel.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_PDFtoWordFragment)
        }

        binding.PDFtoPPT.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_PDFtoWordFragment)
        }

        binding.PDFtoJPG.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_PDFtoWordFragment)
        }

        binding.PDFtoLongImage.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_PDFtoWordFragment)
        }

        binding.scanIdDocumentButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_idDocumentFragment)
        }

        binding.imageToTextButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_textRecognitionFragment)
        }

        binding.improvedPortraitButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_improvedPortraitFragment)
        }

        binding.photoOnIdButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_photoOnIdFragment)
        }

        binding.questionnaireButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_questionnaireFragment)
        }

        binding.bookScanButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_bookScanFragment)
        }

        binding.pptButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_pptScannerFragment)
        }

        binding.importImageButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_importFileFragment)
        }

        binding.qrCodeButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_qrCodeScannerFragment)
        }

        binding.addSignatureButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_addSignatureFragment)
        }

        binding.addPdfPasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_selectFileForPasswordFragment)
        }

        binding.fileSettingsButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_importFileFragment)
        }

        binding.fileImportButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_importFileFragment)
        }

        binding.unZipFileButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_importFileFragment)
        }

        binding.waterMarkToPDF.setOnClickListener {
            findNavController().navigate(
                R.id.action_toolsFragment_to_selectFileForWaterMarkFragment
            )
        }

        binding.mergeFilesButton.setOnClickListener {
            findNavController().navigate(R.id.action_toolsFragment_to_selectFilesToMergeFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
