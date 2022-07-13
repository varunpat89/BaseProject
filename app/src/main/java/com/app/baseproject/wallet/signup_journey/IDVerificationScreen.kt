package com.app.baseproject.wallet.signup_journey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.baseproject.R
import com.app.baseproject.databinding.IdVerificationScreenBinding
import com.app.baseproject.utils.AppConstants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class IDVerificationScreen : Fragment() {

    private lateinit var binding: IdVerificationScreenBinding
    private val TAG = IDVerificationScreen::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = IdVerificationScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(AppConstants.DELAY_MILLIS)
            navigateToUploadDocumentSuccessScreen()
        }
    }

    private fun navigateToUploadDocumentSuccessScreen() {
        findNavController().navigate(
            R.id.action_idVerificationScreen_to_uploadDocumentSuccessScreen
        )
    }
}