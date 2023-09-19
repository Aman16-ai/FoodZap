package com.example.foodzap.data.repository.Authentication

import com.example.foodzap.data.model.api_payload.SendOtpPayload
import com.example.foodzap.data.model.api_response.SendOtpResponse

interface AuthRepo {

    suspend fun getOtp(sendOtpPayload: SendOtpPayload) : SendOtpResponse?
}