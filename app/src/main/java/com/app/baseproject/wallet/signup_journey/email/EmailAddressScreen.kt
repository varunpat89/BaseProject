package com.app.baseproject.wallet.signup_journey.email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.baseproject.R
import com.app.baseproject.databinding.EmailAddressScreenBinding

class EmailAddressScreen : Fragment() {

    private lateinit var binding: EmailAddressScreenBinding
    private val TAG = EmailAddressScreen::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EmailAddressScreenBinding.inflate(inflater, container, false)
        with(binding)
        {
            setOnClickEvent(binding)
        }
        return binding.root
    }

    private fun setOnClickEvent(binding: EmailAddressScreenBinding) {
        binding.btnContinue.setOnClickListener {
            navigateToEmailConfirmationScreen()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun navigateToEmailConfirmationScreen() {
        findNavController().navigate(
            R.id.action_emailAddressScreen_to_emailConfirmationScreen
        )
    }
}