package com.geektech.testapp.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.geektech.testapp.R
import com.geektech.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavView.background = null

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavView.setupWithNavController(navController)

        binding.fab.setOnClickListener {
            navController.navigate(R.id.documentFragment)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    window.statusBarColor = ContextCompat.getColor(this, R.color.primary)
                    binding.bottomAppBar.visibility = View.GONE
                    binding.fab.visibility = View.GONE
                }
                R.id.homeFragment -> {
                    window.statusBarColor = ContextCompat.getColor(this, R.color.whitish)
                    binding.bottomAppBar.visibility = View.VISIBLE
                    binding.fab.visibility = View.VISIBLE
                }
                R.id.toolsFragment -> {
                    window.statusBarColor = ContextCompat.getColor(this, R.color.white)
                    binding.bottomAppBar.visibility = View.VISIBLE
                    binding.fab.visibility = View.VISIBLE
                }
                R.id.filesFragment -> {
                    window.statusBarColor = ContextCompat.getColor(this, R.color.white)
                    binding.bottomAppBar.visibility = View.VISIBLE
                    binding.fab.visibility = View.VISIBLE
                }
                R.id.profileFragment -> {
                    window.statusBarColor = ContextCompat.getColor(this, R.color.whitish)
                    binding.bottomAppBar.visibility = View.VISIBLE
                    binding.fab.visibility = View.VISIBLE
                }
                R.id.registerFragment -> setLightGrayStatusBar()
                R.id.loginFragment -> setLightGrayStatusBar()
                R.id.regionFragment -> setLightGrayStatusBar()
                R.id.confirmPhoneFragment -> setLightGrayStatusBar()
                R.id.forgotPasswordFragment -> setLightGrayStatusBar()
                R.id.verifyIdentityFragment -> setLightGrayStatusBar()
                R.id.documentFragment -> setDarkBlueStatusBar()
                R.id.batchModeFragment -> setDarkBlueStatusBar()
                R.id.madePhotoBatchModeFragment -> setDarkBlueStatusBar()
                R.id.enterPhotoFragment -> setDarkBlueStatusBar()
                R.id.pptScannerFragment -> setDarkBlueStatusBar()
                R.id.photoOnIdFragment -> setDarkBlueStatusBar()
                R.id.textRecognitionFragment -> setDarkBlueStatusBar()
                R.id.photoToWordFragment -> setDarkBlueStatusBar()
                R.id.idDocumentFragment -> setDarkBlueStatusBar()
                R.id.idDocumentMadePhotoFragment -> setDarkBlueStatusBar()
                R.id.questionnaireFragment -> setDarkBlueStatusBar()
                R.id.questionnaireMadePhotoFragment -> setDarkBlueStatusBar()
                R.id.questionnaireCheckFragment -> setDarkBlueStatusBar()
                R.id.createQuestionnaireFragment -> setDarkBlueStatusBar()
                R.id.improvedPortraitFragment -> setDarkBlueStatusBar()
                R.id.improvedPortraitMadePhotoFragment -> setDarkBlueStatusBar()
                R.id.bookScanFragment -> setDarkBlueStatusBar()
                R.id.bookScannerMadePhotoFragment -> setDarkBlueStatusBar()
                R.id.moreFragment -> setDarkBlueStatusBar()
                R.id.postCardMakePhotoFragment -> setDarkBlueStatusBar()
                R.id.postCardMadePhotoFragment -> setDarkBlueStatusBar()
                R.id.qrCodeScannerFragment -> setDarkBlueStatusBar()
                R.id.moveFoldersFragment -> setDarkWhiteStatusBar()
                R.id.moveToFragment -> setDarkWhiteStatusBar()
                R.id.copyFragment -> setDarkWhiteStatusBar()
                R.id.scannerCameraFragment -> setDarkBlueStatusBar()
                R.id.cuttingProgressingFragment -> setDarkBlueStatusBar()
                R.id.recognizeFragment -> setDarkBlueStatusBar()
                R.id.recognizeEditingFragment -> setDarkBlueStatusBar()
                R.id.editColorFiltersFragment -> setDarkBlueStatusBar()
                R.id.spotFragment -> setDarkBlueStatusBar()
                R.id.addTextAnywhereFragment -> setDarkBlueStatusBar()
                R.id.addColorToPhotoFragment -> setDarkBlueStatusBar()
                else -> {
                    window.statusBarColor = ContextCompat.getColor(this, R.color.white)
                    binding.bottomAppBar.visibility = View.GONE
                    binding.fab.visibility = View.GONE
                }
            }
        }
    }

    private fun setDarkBlueStatusBar() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.dark_blue)
        binding.bottomAppBar.visibility = View.GONE
        binding.fab.visibility = View.GONE
    }

    private fun setDarkWhiteStatusBar() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.dark_white)
        binding.bottomAppBar.visibility = View.GONE
        binding.fab.visibility = View.GONE
    }

    private fun setLightGrayStatusBar() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.whitish)
        binding.bottomAppBar.visibility = View.GONE
        binding.fab.visibility = View.GONE
    }
}
