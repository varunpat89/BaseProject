package com.app.baseproject.wallet.wallet_selection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.baseproject.utils.BBLogger
import com.app.baseproject.utils.core.SingleEvent
import com.backbase.retailbanking.onboarding.usecase.OnboardingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class WalletSelectionViewModel(private val onboardingUseCase: OnboardingUseCase) : ViewModel() {

    private val TAG = WalletSelectionViewModel::class.java.simpleName
    private val _onFiatWalletClickEvent = MutableStateFlow<SingleEvent<Unit>?>(null)
    val onFiatWalletClickEvent: StateFlow<SingleEvent<Unit>?> = _onFiatWalletClickEvent

    fun isOnboardingInfoShown() = onboardingUseCase.isOnboardingInfoShown()

    fun onFiatWalletClick() {
        BBLogger.error(TAG,"onClickFiatWallet")
        viewModelScope.launch {
            _onFiatWalletClickEvent.emit(SingleEvent(Unit))
        }
    }

    fun onCryptoWalletClick()
    {
        BBLogger.error(TAG,"onClickCryptoWallet")

    }

}