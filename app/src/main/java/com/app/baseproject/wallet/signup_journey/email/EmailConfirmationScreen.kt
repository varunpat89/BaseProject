package com.app.baseproject.wallet.signup_journey.email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.baseproject.databinding.EmailConfirmationScreenBinding

class EmailConfirmationScreen : Fragment() {

    private lateinit var binding: EmailConfirmationScreenBinding
    private val TAG = EmailConfirmationScreen::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EmailConfirmationScreenBinding.inflate(inflater, container, false)
        with(binding)
        {
            setOnClickEvent(binding)
        }
        return binding.root
    }

    private fun setOnClickEvent(binding: EmailConfirmationScreenBinding) {
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}