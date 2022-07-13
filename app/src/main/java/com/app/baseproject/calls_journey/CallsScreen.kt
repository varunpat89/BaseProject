package com.app.baseproject.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.baseproject.databinding.CallsScreenBinding

class CallsScreen : Fragment() {

    private lateinit var binding: CallsScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CallsScreenBinding.inflate(inflater, container, false)

        return binding.root
    }
}