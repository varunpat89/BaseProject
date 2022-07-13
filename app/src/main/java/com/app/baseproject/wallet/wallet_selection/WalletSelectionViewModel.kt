package com.app.baseproject.wallet.wallet_selection

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.baseproject.R
import com.app.baseproject.utils.BBLogger
import com.app.baseproject.utils.core.SingleEvent
import com.app.baseproject.onboarding.usecase.OnboardingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class WalletSelectionViewModel(private val onboardingUseCase: OnboardingUseCase, application: Application) : AndroidViewModel(application) {

    private val TAG = WalletSelectionViewModel::class.java.simpleName
    private val _onFiatWalletClickEvent = MutableStateFlow<SingleEvent<String>?>(null)
    val onFiatWalletClickEvent: StateFlow<SingleEvent<String>?> = _onFiatWalletClickEvent

    fun isOnboardingInfoShown() = onboardingUseCase.isOnboardingInfoShown()

    fun onFiatWalletClick() {
        BBLogger.error(TAG,"onClickFiatWallet")
        viewModelScope.launch {
            val walletName = getApplication<Application>().resources.getString(R.string.fiat_wallet)
            _onFiatWalletClickEvent.emit(SingleEvent(walletName))
        }
    }

    fun onCryptoWalletClick()
    {
        BBLogger.error(TAG,"onClickCryptoWallet")

    }

}