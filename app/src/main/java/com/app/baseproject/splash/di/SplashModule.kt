package com.app.baseproject.splash.di

import com.app.baseproject.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val splashModule = module() {
    viewModel { SplashViewModel() }
}