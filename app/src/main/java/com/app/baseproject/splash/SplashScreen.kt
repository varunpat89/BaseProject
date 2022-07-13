package com.app.baseproject.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.baseproject.R
import com.app.baseproject.databinding.SplashScreenBinding
import com.app.baseproject.splash.di.splashModule
import com.app.baseproject.utils.AppConstants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class SplashScreen : Fragment() {

    private lateinit var binding: SplashScreenBinding
    private val viewModel by viewModel<SplashViewModel>()
    private val TAG = SplashScreen::class.java.simpleName
    private var isLaunchAppFromBackground = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(splashModule)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unloadKoinModules(splashModule)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashScreenBinding.inflate(inflater, container, false)
        startOnboardingScreenAfterDelay()

        return binding.root
    }

    private fun startOnboardingScreenAfterDelay() {
        lifecycleScope.launch {
            delay(AppConstants.SPLASH_MILLIS)
            findNavController().navigate(R.id.action_splashScreen_to_BottomMenuScreen)
        }
    }

    override fun onResume() {
        super.onResume()
        if (isLaunchAppFromBackground) {
            isLaunchAppFromBackground = false
            startOnboardingScreenAfterDelay()
        }
    }

    override fun onPause() {
        super.onPause()
        isLaunchAppFromBackground = true
    }
}