package com.app.baseproject.contact_journey.data

import com.app.baseproject.contact_journey.data.remote.RemoteDataSource
import com.app.baseproject.model.BaseApiResponse
import com.app.baseproject.contact_journey.model.response.ContactResponse
import com.app.baseproject.utils.network.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository(private val remoteDataSource: RemoteDataSource) :
    BaseApiResponse() {
    suspend fun getContacts(): Flow<NetworkResult<ContactResponse>> {
        return flow<NetworkResult<ContactResponse>> {
            emit(safeApiCall { remoteDataSource.getContacts() })
        }.flowOn(Dispatchers.IO)
    }
}

