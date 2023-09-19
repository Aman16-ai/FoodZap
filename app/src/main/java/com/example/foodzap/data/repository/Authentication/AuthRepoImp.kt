package com.example.foodzap.data.repository.Authentication

import com.example.foodzap.data.model.api_payload.SendOtpPayload
import com.example.foodzap.data.model.api_response.SendOtpResponse
import com.example.foodzap.data.services.authentication.AuthenticationService

class AuthRepoImp : AuthRepo {
    override suspend fun getOtp(sendOtpPayload: SendOtpPayload): SendOtpResponse? {
        val result : SendOtpResponse? = AuthenticationService
            .authenticationServiceInstance
            .getOtp(sendOtpPayload)
            .body()
        return result
    }

}