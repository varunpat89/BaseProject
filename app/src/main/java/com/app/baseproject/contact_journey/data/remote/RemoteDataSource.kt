package com.app.baseproject.contact_journey.data.remote

import com.app.baseproject.contact_journey.model.response.ContactResponse
import retrofit2.Response

class RemoteDataSource(private val contactApi: ContactApi) {
    suspend fun getContacts(): Response<ContactResponse> {
        return contactApi.getContacts()
    }

}
