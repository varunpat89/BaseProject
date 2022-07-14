package com.app.baseproject.wallet.wallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.baseproject.utils.core.SingleEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WalletViewModel : ViewModel() {

    private val _onSignUpClickEvent = MutableStateFlow<SingleEvent<Unit>?>(null)
    val onSignUpClickEvent: StateFlow<SingleEvent<Unit>?> = _onSignUpClickEvent

    fun onSignUpClick() {
        viewModelScope.launch {
            _onSignUpClickEvent.emit(SingleEvent(Unit))
        }
    }
}