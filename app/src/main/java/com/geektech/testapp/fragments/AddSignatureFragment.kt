package com.geektech.testapp.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.view.Window
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.geektech.testapp.R
import com.geektech.testapp.base.BaseEmptyFragment
import com.geektech.testapp.databinding.FragmentAddSignatureBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class AddSignatureFragment : BaseEmptyFragment<FragmentAddSignatureBinding>(
    FragmentAddSignatureBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog

    @SuppressLint("InflateParams")
    override fun setupClickListener() = with(binding) {
        clickBack.setOnClickListener {
            Dialog(requireContext(), R.style.RoundedCornersDialog).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.dialog_undo_edits)
                show()
            }
        }
        linIdSignature.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.sheet_scan_import, null)
            dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
            dialog.setContentView(dialogView)
            dialog.findViewById<LinearLayout>(R.id.importFromAlbumLL)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(
                    R.id.action_addSignatureFragment_to_choosePhotoFragment
                )
            }
            dialog.findViewById<LinearLayout>(R.id.scanSignatureLL)?.setOnClickListener {
                dialog.hide()
                findNavController().navigate(
                    R.id.action_addSignatureFragment_to_scannerCameraFragment
                )
            }
            dialog.show()
        }
        imgToolbarShare.setOnClickListener {
            Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show()
        }
        btnBottomNavApply.setOnClickListener {
            findNavController().navigate(
                R.id.action_addSignatureFragment_to_signatureFeaturesFragment
            )
        }
    }
}
