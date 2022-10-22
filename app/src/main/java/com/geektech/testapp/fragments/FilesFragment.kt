package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.testapp.R
import com.geektech.testapp.adapters.FoldersAdapter
import com.geektech.testapp.adapters.SearchDocumentAdapter
import com.geektech.testapp.databinding.FragmentFileBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class FilesFragment : Fragment() {

    private var _binding: FragmentFileBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFileBinding.inflate(inflater, container, false)

        val filesAdapter = FoldersAdapter()
        val documentsAdapter = SearchDocumentAdapter()

        binding.searchDocumentRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ConcatAdapter(filesAdapter, documentsAdapter)
        }

        filesAdapter.onItemClick = {
            val dialogView = layoutInflater.inflate(R.layout.fragment_folders_more_menu, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.findViewById<TextView>(R.id.addIconToDesktopButton)?.setOnClickListener {
                dialog.hide()
                Toast.makeText(
                    requireContext(),
                    "Добавить значок на рабочем столе",
                    Toast.LENGTH_SHORT
                ).show()
            }
            dialog.findViewById<TextView>(R.id.moveToButton)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(R.id.action_filesFragment_to_moveFoldersFragment)
            }
            dialog.findViewById<TextView>(R.id.renameButton)?.setOnClickListener {
                dialog.hide()
                val renameDialogView = layoutInflater.inflate(
                    R.layout.fragment_rename_overlay, null
                )
                dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
                dialog.setContentView(renameDialogView)
                dialog.show()
            }
            dialog.findViewById<TextView>(R.id.deleteButton)?.setOnClickListener {
                dialog.hide()
                Toast.makeText(
                    requireContext(),
                    "Папка успешно удалена!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            dialog.show()
        }

        binding.arrowDownIcon.setOnClickListener {
            findNavController().navigate(R.id.action_filesFragment_to_tagsFragment)
        }

        binding.ivFolder.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.fragment_new_folder_menu, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }

        binding.sortButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.fragment_sorting_type_menu, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.show()
        }

        binding.menuButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.fragment_import_more_menu, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.findViewById<TextView>(R.id.tv_import_files)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(R.id.action_filesFragment_to_importFileFragment)
            }
            dialog.findViewById<TextView>(R.id.tv_import_image)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(R.id.action_filesFragment_to_selectFileFragment)
            }
            dialog.show()
        }

        binding.searchButton.setOnClickListener {
            findNavController().navigate(R.id.action_filesFragment_to_searchFragment)
        }

        binding.gridTypeButton.setOnClickListener {
            when (binding.gridTypeText.text) {
                getString(R.string.first_grid_type) -> {
                    binding.gridTypeButton.setImageDrawable(
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_grid_one_column)
                    )
                    binding.searchDocumentRv.visibility = View.GONE
                    binding.gridTypeText.visibility = View.VISIBLE
                    binding.gridTypeText.text = getString(R.string.second_grid_type)
                }
                getString(R.string.second_grid_type) -> {
                    binding.gridTypeButton.setImageDrawable(
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_grid_type_3)
                    )
                    binding.searchDocumentRv.visibility = View.GONE
                    binding.gridTypeText.visibility = View.VISIBLE
                    binding.gridTypeText.text = getString(R.string.third_grid_type)
                }
                getString(R.string.first_grid_type) -> {
                    binding.searchDocumentRv.visibility = View.VISIBLE
                    binding.gridTypeText.visibility = View.GONE
                    binding.gridTypeText.text = getString(R.string.first_grid_type)
                    binding.gridTypeButton.setImageDrawable(
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_grid)
                    )
                }
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
