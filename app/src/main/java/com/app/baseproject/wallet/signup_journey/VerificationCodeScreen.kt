package com.app.baseproject.wallet.signup_journey

import `in`.aabhasjindal.otptextview.OTPListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.baseproject.R
import com.app.baseproject.databinding.VerificationCodeScreenBinding
import com.app.baseproject.utils.AppConstants
import com.app.baseproject.utils.BBLogger
import com.app.baseproject.utils.core.KeyboardUtil
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class VerificationCodeScreen : Fragment() {

    private lateinit var binding: VerificationCodeScreenBinding
    private val TAG = VerificationCodeScreen::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = VerificationCodeScreenBinding.inflate(inflater, container, false)
        with(binding)
        {
            setOnClickEvent(binding)
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedNumber = getArguments()?.getInt(AppConstants.NUMBER)
        binding.textViewDescription.text =
            getString(R.string.enter_the_code_we_sent_to) + " $selectedNumber"
    }

    private fun setOnClickEvent(binding: VerificationCodeScreenBinding) {
        binding.textViewResendCode.setOnClickListener {
            //TODO click event of Resend code
        }
        binding.imgClose.setOnClickListener {
            navigateToWalletScreen()
        }

        binding.pinView.requestFocus()
        KeyboardUtil.showKeyboard(binding.pinView)
        binding.pinView.otpListener = object : OTPListener {
            override fun onInteractionListener() {
                BBLogger.error(TAG, "onInteractionListener")
            }

            override fun onOTPComplete(pin: String) {
                BBLogger.error(TAG, "onOTPComplete: $pin")
                hidePinView()
                showProgressBar()
                lifecycleScope.launch {
                    delay(AppConstants.DELAY_MILLIS)
                    navigateToIDVerificationScreen()
                }
            }
        }
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
        binding.textViewValidatingCode.visibility = View.VISIBLE
    }

    private fun showPinView() {
        binding.pinView.visibility = View.VISIBLE
    }

    private fun hidePinView() {
        binding.pinView.visibility = View.GONE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
        binding.textViewValidatingCode.visibility = View.GONE
    }

    private fun navigateToWalletScreen() {
        findNavController().navigate(
            R.id.action_verificationCodeScreen_to_walletScreen
        )
    }

    private fun navigateToIDVerificationScreen() {
        findNavController().navigate(
            R.id.action_verificationCodeScreen_to_idVerificationScreen
        )
    }
}