package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.FragmentMoveFoldersBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MoveFoldersFragment : Fragment() {

    private var _binding: FragmentMoveFoldersBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoveFoldersBinding.inflate(inflater, container, false)

        binding.shareButton.setOnClickListener {
            findNavController().navigate(R.id.action_moveFoldersFragment_to_shareFileFragment)
        }

        binding.moveToButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.fragment_task_details_overlay, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.findViewById<LinearLayout>(R.id.copyLL)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(R.id.action_moveFoldersFragment_to_copyFragment)
            }
            dialog.findViewById<LinearLayout>(R.id.transferLL)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(R.id.action_moveFoldersFragment_to_moveToFragment)
            }
            dialog.show()
        }

        binding.moreButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.fragment_files_more_menu, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.findViewById<TextView>(R.id.tv_block)?.setOnClickListener {
                Dialog(requireContext(), R.style.RoundedCornersDialog).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.dialog_activate_protection)
                    show()
                }
            }
            dialog.findViewById<TextView>(R.id.tv_tag)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(
                    R.id.action_moveFoldersFragment_to_addNewTagFragment
                )
            }
            dialog.findViewById<TextView>(R.id.tv_download)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(
                    R.id.action_moveFoldersFragment_to_downloadFilesFragment
                )
            }
            dialog.show()
        }

        binding.mergeFilesButton.setOnClickListener {
            findNavController().navigate(R.id.action_moveFoldersFragment_to_mergeFilesFragment)
        }

        binding.deleteButton.setOnClickListener {
            AlertDialog.Builder(requireContext(), R.style.AlertDialogTheme)
                .setTitle(getString(R.string.delete_file))
                .setMessage(getString(R.string.delete_dialog_subtitle))
                .setNegativeButton(getString(R.string.cancel)) { _, _ -> }
                .setPositiveButton(getString(R.string.delete)) { _, _ -> }.create().show()
        }

        binding.xButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.emptySpace.setOnClickListener {
            binding.mergeFilesButton.visibility = View.GONE
            binding.renameButton.visibility = View.VISIBLE
        }

        binding.renameButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.fragment_rename_overlay, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.findViewById<RelativeLayout>(R.id.documentNameSettingRL)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(
                    R.id.action_moveFoldersFragment_to_autoNameTemplateFragment
                )
            }
            dialog.show()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
