package com.app.baseproject.wallet.wallet.di

import com.app.baseproject.wallet.wallet.WalletViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val walletModule = module {

    viewModel {
        WalletViewModel()
    }
}