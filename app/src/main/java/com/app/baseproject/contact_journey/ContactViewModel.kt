package com.app.baseproject.contact_journey

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.baseproject.contact_journey.usecase.ContactUseCase
import com.app.baseproject.contact_journey.model.response.ContactResponse
import com.app.baseproject.utils.BBLogger
import com.app.baseproject.utils.network.NetworkResult
import kotlinx.coroutines.launch

class ContactViewModel(private val contactUseCase: ContactUseCase) : ViewModel() {

    private val _response: MutableLiveData<NetworkResult<ContactResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<ContactResponse>> = _response

    private val _downloadResponse: MutableLiveData<Boolean> = MutableLiveData()
    val downloadResponse = _downloadResponse

    fun fetchContactResponse() {
        BBLogger.error("TAG", "fetchDogResponse")
        viewModelScope.launch {
            contactUseCase.getContacts().collect { values ->
                _response.value = values
            }
        }
    }

}