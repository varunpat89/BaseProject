package com.app.baseproject.wallet.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.baseproject.R
import com.app.baseproject.databinding.WalletScreenBinding
import com.app.baseproject.utils.AppConstants
import com.app.baseproject.wallet.wallet.di.walletModule
import kotlinx.coroutines.flow.collect
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class WalletScreen : Fragment() {

    private lateinit var binding: WalletScreenBinding
    private val TAG = WalletScreen::class.java.simpleName
    private val viewModel by viewModels<WalletViewModel>()
    private var walletName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(walletModule)
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(walletModule)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WalletScreenBinding.inflate(inflater, container, false)
        with(binding)
        {
            viewModel = this@WalletScreen.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        walletName = getArguments()?.getString(AppConstants.WALLET_NAME)
        binding.txtTitle.text = walletName

        setObserver()

        setOnClickEvent()

    }

    private fun setObserver() {
        lifecycleScope.launchWhenResumed {
            // Listen to Fiat wallet button click
            viewModel.onSignUpClickEvent.collect { event ->
                event?.handle {
                    navigateToSignUpScreen()
                }
            }
        }
    }


    private fun setOnClickEvent() {
        binding.imgBack.setOnClickListener {
            navigateToWalletScreen()
        }
    }

    private fun navigateToSignUpScreen() {
        val bundle = Bundle()
        bundle.putString(AppConstants.WALLET_NAME, walletName)
        findNavController().navigate(
            R.id.action_walletScreen_to_signUpScreen, bundle
        )
    }

    private fun navigateToWalletScreen() {
        findNavController().navigate(
            R.id.action_walletScreen_to_walletSelectionScreen
        )
    }
}