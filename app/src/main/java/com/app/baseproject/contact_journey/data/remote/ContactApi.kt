package com.app.baseproject.contact_journey.data.remote

import com.app.baseproject.contact_journey.model.response.ContactResponse
import com.app.baseproject.utils.network.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ContactApi {

    @GET(Constants.RANDOM_URL)
    suspend fun getContacts(): Response<ContactResponse>
}
