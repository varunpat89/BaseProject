package com.app.baseproject.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.app.baseproject.R
import com.app.baseproject.databinding.OnboardingScreenBinding
import com.google.android.material.button.MaterialButton
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class OnboardingScreen : Fragment() {

    private lateinit var binding: OnboardingScreenBinding
    private val viewModel by viewModel<OnboardingViewModel>()
    private val TAG = OnboardingScreen::class.java.simpleName

    companion object {
        @JvmStatic
        @BindingAdapter("srcRemote")
        fun bindImage(imageView: ImageView, url: String) {
            imageView.load(url) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(onboardingModule)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unloadKoinModules(onboardingModule)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OnboardingScreenBinding.inflate(inflater, container, false)
        with(binding)
        {
            viewModel = this@OnboardingScreen.viewModel
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPager()

        setObserver()

        // fetch onboarding info
        viewModel.fetchOnboardingInfo()

    }

    private fun setObserver() {
        lifecycleScope.launchWhenCreated {
            // Set viewpager adapter
            viewModel.onboardingInfo.collect { lists ->
                lists?.let { setAdapter(lists) }
            }
        }

        lifecycleScope.launchWhenResumed {
            // Listen to Let's start button click
            viewModel.onboardingFinishEvent.collect { event ->
                event?.handle { navigateToWalletScreen() }
            }
        }

    }

    private fun setAdapter(dataList: List<Triple<String, String, String>>) {
        val pager = binding.viewPagerOnBoaring
        val pagerIndicator = binding.onboardingJourneyOnboardingScreenPagerIndicator

        // Set adapter
        pager.adapter = OnBoardingPagerAdapter(dataList)
        binding.viewPagerOnBoaring.setCurrentItem(0, true)

        // Set circle page indicator
        pagerIndicator.setViewPager(pager)
    }

    private fun setViewPager() {
        // Set page change listener
        binding.viewPagerOnBoaring.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val pager = binding.viewPagerOnBoaring

                val itemCount = pager.adapter?.itemCount ?: 0
                setButtonEnability(position == (itemCount - 1), binding.btnGetStarted)
            }
        })
    }

    private fun setButtonEnability(isEnable: Boolean, btnStarted: MaterialButton) {
        if (isEnable) {
            btnStarted.isEnabled = true
            btnStarted.setTextColor(
                ContextCompat.getColorStateList(
                    requireContext(),
                    R.color.white
                )
            )
            val colorStateList = ContextCompat.getColorStateList(requireContext(), R.color.primary)
            btnStarted.strokeColor = colorStateList
            btnStarted.setBackgroundTintList(colorStateList)

        } else {
            btnStarted.isEnabled = false
            val colorStateList = ContextCompat.getColorStateList(requireContext(), R.color.primary)
            btnStarted.strokeColor = colorStateList
            btnStarted.setTextColor(colorStateList)
            btnStarted.setBackgroundTintList(
                ContextCompat.getColorStateList(
                    requireContext(),
                    R.color.white
                )
            )
        }
    }

    private fun navigateToWalletScreen() {
        findNavController().navigate(
            R.id.action_onBoaringScreen_to_walletScreen
        )
    }

    private fun shouldSkipThisStep() {
        if (viewModel.isOnboardingInfoShown()) {
            navigateToWalletScreen()
        }
    }
}