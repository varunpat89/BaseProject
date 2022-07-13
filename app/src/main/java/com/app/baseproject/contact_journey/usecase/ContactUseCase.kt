package com.app.baseproject.contact_journey.usecase

import com.app.baseproject.contact_journey.model.response.ContactResponse
import com.app.baseproject.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface ContactUseCase {
    suspend fun getContacts() : Flow<NetworkResult<ContactResponse>>
}