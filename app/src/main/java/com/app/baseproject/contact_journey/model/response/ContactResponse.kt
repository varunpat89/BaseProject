package com.app.baseproject.contact_journey.model.response

import com.google.gson.annotations.SerializedName

data class ContactResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)
