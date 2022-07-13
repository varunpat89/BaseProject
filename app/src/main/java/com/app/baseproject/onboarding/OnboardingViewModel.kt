package com.app.baseproject.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.baseproject.utils.core.SingleEvent
import com.app.baseproject.onboarding.usecase.OnboardingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class OnboardingViewModel(private val onboardingUseCase: OnboardingUseCase) : ViewModel() {

    private val _onboardingInfo = MutableStateFlow<List<Triple<String, String, String>>?>(null)
    val onboardingInfo: StateFlow<List<Triple<String, String, String>>?> = _onboardingInfo

    private val _onboardingFinishEvent = MutableStateFlow<SingleEvent<Unit>?>(null)
    val onboardingFinishEvent: StateFlow<SingleEvent<Unit>?> = _onboardingFinishEvent

    fun isOnboardingInfoShown() = onboardingUseCase.isOnboardingInfoShown()

    fun onLogin() {

    }


    fun getStart() {
        viewModelScope.launch {
            onboardingUseCase.setOnboardingInfoShown()

            _onboardingFinishEvent.emit(SingleEvent(Unit))
        }
    }

    fun fetchOnboardingInfo() {
        viewModelScope.launch {
            val results = onboardingUseCase.getOnboardingInfo()
            _onboardingInfo.emit(results)
        }
    }

}