package com.app.baseproject.onboarding

import com.app.baseproject.onboarding.usecase.OnboardingUseCase
import com.app.baseproject.onboarding.usecase.OnboardingUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val onboardingModule = module {

    single<OnboardingUseCase> {
        OnboardingUseCaseImpl(get())
    }

    viewModel {
        OnboardingViewModel(get())
    }
}