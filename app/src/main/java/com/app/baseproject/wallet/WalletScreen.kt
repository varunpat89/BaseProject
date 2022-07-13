package com.app.baseproject.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.baseproject.R
import com.app.baseproject.databinding.WalletScreenBinding

class WalletScreen : Fragment() {

    private lateinit var binding: WalletScreenBinding
    private val TAG = WalletScreen::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WalletScreenBinding.inflate(inflater, container, false)

        with(binding)
        {
            setOnClickEvent(binding)
        }
        return binding.root
    }

    private fun setOnClickEvent(binding: WalletScreenBinding) {
        binding.cardSignUp.setOnClickListener {
            navigateToSignUpScreen()
        }

        binding.imgBack.setOnClickListener {
            navigateToWalletScreen()
        }
    }

    private fun navigateToSignUpScreen() {
        findNavController().navigate(
            R.id.action_walletScreen_to_signUpScreen
        )
    }

    private fun navigateToWalletScreen() {
        findNavController().navigate(
            R.id.action_walletScreen_to_walletSelectionScreen
        )
    }
}