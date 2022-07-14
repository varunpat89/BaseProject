package com.app.baseproject.onboarding.usecase

import com.app.baseproject.utils.preferance.PreferenceManager

internal class OnboardingUseCaseImpl(
    private val preferenceManager: PreferenceManager
) : OnboardingUseCase {

    companion object {
        private const val KEY_SHOULD_DISPLAY_ONBOARDING_INFO = "key.should_display_onboarding_info"

        private const val ONBOARDING_IMAGE_1 =
            "https://cdn.pixabay.com/photo/2018/02/01/06/40/rocket-3122690_1280.png"
        private const val ONBOARDING_IMAGE_2 =
            "https://cdn.pixabay.com/photo/2014/10/23/10/10/dollars-499481_1280.jpg"
        private const val ONBOARDING_IMAGE_3 =
            "https://cdn.pixabay.com/photo/2015/08/29/20/21/safe-913452_1280.jpg"
        private const val ONBOARDING_IMAGE_4 =
            "https://cdn.pixabay.com/photo/2018/02/01/06/40/rocket-3122690_1280.png"
        private const val ONBOARDING_IMAGE_5 =
            "https://cdn.pixabay.com/photo/2014/10/23/10/10/dollars-499481_1280.jpg"
    }

    override fun getOnboardingInfo() = listOf(
        Triple(
            ONBOARDING_IMAGE_1,
             "Features introduction 1",
             "1 To let user know how can FIAT Wallet\\nhelp them to solve their problems"
        ),
        Triple(
            ONBOARDING_IMAGE_2,
            "Features introduction 2",
             "2 To let user know how can FIAT Wallet\\nhelp them to solve their problems"
        ),
        Triple(
            ONBOARDING_IMAGE_3,
            "Features introduction 3",
            "3 To let user know how can FIAT Wallet\\nhelp them to solve their problems"
        ),
        Triple(
            ONBOARDING_IMAGE_4,
            "Features introduction 4",
            "4 To let user know how can FIAT Wallet\\nhelp them to solve their problems"
        ),
        Triple(
            ONBOARDING_IMAGE_5,
            "Features introduction 5",
            "5 To let user know how can FIAT Wallet\\nhelp them to solve their problems"
        )
    )

    override fun setOnboardingInfoShown() {
        preferenceManager.saveIsDisplayOnboarding(true)
    }

    override fun isOnboardingInfoShown(): Boolean {
        return preferenceManager.isDisplayOnBoarding()
    }

}