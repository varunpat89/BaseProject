package com.app.baseproject.wallet.wallet_selection.di

import com.app.baseproject.onboarding.OnboardingViewModel
import com.app.baseproject.wallet.wallet_selection.WalletSelectionViewModel
import com.backbase.retailbanking.onboarding.usecase.OnboardingUseCase
import com.backbase.retailbanking.onboarding.usecase.OnboardingUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val walletSelectionModule = module {

    single<OnboardingUseCase> {
        OnboardingUseCaseImpl(get())
    }

    viewModel {
        WalletSelectionViewModel(get())
    }
}