package com.app.baseproject.wallet.signup_journey

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.baseproject.R
import com.app.baseproject.databinding.SignUpScreenBinding
import com.app.baseproject.utils.AppConstants

class SignUpScreen : Fragment() {

    private lateinit var binding: SignUpScreenBinding
    private val TAG = SignUpScreen::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignUpScreenBinding.inflate(inflater, container, false)

        with(binding)
        {
            setOnClickEvent(binding)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val walletName = getArguments()?.getString(AppConstants.WALLET_NAME)
        binding.txtTitle.text = getString(R.string.sign_up_to) + " $walletName"
    }

    private fun setOnClickEvent(binding: SignUpScreenBinding) {
        binding.btnSignUp.setOnClickListener {
            navigateToSignUpScreen(binding.edtNumber.text)
        }
    }

    private fun navigateToSignUpScreen(text: Editable) {
        val bundle = Bundle()
        bundle.putInt(AppConstants.NUMBER, text.toString().toInt())
        findNavController().navigate(
            R.id.action_signUpScreen_to_verificationCodeScreen, bundle
        )
    }
}