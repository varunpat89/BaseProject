package com.app.baseproject.di

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.app.baseproject.contact_journey.data.Repository
import com.app.baseproject.contact_journey.data.remote.RemoteDataSource
import com.app.baseproject.utils.AppConstants
import com.app.baseproject.utils.preferance.PreferenceManager
import com.app.baseproject.contact_journey.ContactViewModel
import com.app.baseproject.contact_journey.usecase.ContactUseCase
import com.app.baseproject.contact_journey.usecase.ContactUseCaseImpl
import com.app.baseproject.onboarding.usecase.OnboardingUseCase
import com.app.baseproject.onboarding.usecase.OnboardingUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val coreModule = module {

    single {
        MasterKey.Builder(androidContext())
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
    }

    single(named("PREFERENCE")) {
        EncryptedSharedPreferences.create(
            androidContext(),
            AppConstants.FILE_NAME,
            get(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    single {
        PreferenceManager(get(named("PREFERENCE")))
    }

    single { RemoteDataSource(get()) }

    single { Repository(get()) }

    single<ContactUseCase> {
        ContactUseCaseImpl(get())
    }

    viewModel {
        ContactViewModel(get())
    }

}