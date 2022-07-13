package com.app.baseproject.wallet.wallet_selection.di

import com.app.baseproject.wallet.wallet_selection.WalletSelectionViewModel
import com.app.baseproject.onboarding.usecase.OnboardingUseCase
import com.app.baseproject.onboarding.usecase.OnboardingUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val walletSelectionModule = module {

    single<OnboardingUseCase> {
        OnboardingUseCaseImpl(get())
    }

    viewModel {
        WalletSelectionViewModel(get(), get())
    }
}