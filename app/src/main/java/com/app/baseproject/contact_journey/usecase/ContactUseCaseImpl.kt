package com.app.baseproject.contact_journey.usecase

import com.app.baseproject.contact_journey.data.Repository
import com.app.baseproject.contact_journey.model.response.ContactResponse
import com.app.baseproject.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

class ContactUseCaseImpl(private val repository: Repository) : ContactUseCase {

    override suspend fun getContacts(): Flow<NetworkResult<ContactResponse>> {
        return repository.getContacts()
    }

}