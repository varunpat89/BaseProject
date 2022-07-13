package com.app.baseproject.wallet.signup_journey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.baseproject.R
import com.app.baseproject.databinding.UploadDocumentSuccessScreenBinding
import com.app.baseproject.utils.AppConstants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UploadDocumentSuccessScreen : Fragment() {

    private lateinit var binding: UploadDocumentSuccessScreenBinding
    private val TAG = UploadDocumentSuccessScreen::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UploadDocumentSuccessScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(AppConstants.DELAY_MILLIS)
            navigateToEmailVerificationScreen()
        }
    }

    private fun navigateToEmailVerificationScreen() {
        findNavController().navigate(
            R.id.action_uploadDocumentSuccessScreen_to_EnterEmailAddressScreen
        )
    }
}