package com.app.baseproject.wallet.wallet_selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.baseproject.R
import com.app.baseproject.databinding.OnboardingScreenBinding
import com.app.baseproject.databinding.WalletSelectionScreenBinding
import com.app.baseproject.onboarding.OnboardingViewModel
import com.app.baseproject.utils.BBLogger
import com.app.baseproject.wallet.wallet_selection.di.walletSelectionModule
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class WalletSelectionScreen : Fragment() {

    private lateinit var binding: WalletSelectionScreenBinding
    private val viewModel by viewModel<WalletSelectionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(walletSelectionModule)
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(walletSelectionModule)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WalletSelectionScreenBinding.inflate(inflater, container, false)
        with(binding)
        {
            viewModel = this@WalletSelectionScreen.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BBLogger.error("TAG","onViewCreated")
        setObserver()
    }

    private fun setObserver() {
        lifecycleScope.launchWhenResumed {
            // Listen to Fiat wallet button click
            viewModel.onFiatWalletClickEvent.collect { event ->
                event?.handle {
                    if (shouldSkipThisOnBoarding()) navigateToWalletScreen() else navigateToOnBoardingScreen()
                }
            }
        }

    }

    private fun navigateToOnBoardingScreen() {
        findNavController().navigate(R.id.action_walletSelectionScreen_to_onboardingScreen)
    }

    private fun shouldSkipThisOnBoarding(): Boolean {
        return viewModel.isOnboardingInfoShown()
    }

    private fun navigateToWalletScreen() {
        findNavController().navigate(R.id.action_walletSelectionScreen_to_walletScreen)
    }
}