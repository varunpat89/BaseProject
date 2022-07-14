package com.app.baseproject.onboarding.usecase

internal interface OnboardingUseCase {

    fun getOnboardingInfo(): List<Triple<String, String, String>>

    fun setOnboardingInfoShown()

    fun isOnboardingInfoShown(): Boolean

}

