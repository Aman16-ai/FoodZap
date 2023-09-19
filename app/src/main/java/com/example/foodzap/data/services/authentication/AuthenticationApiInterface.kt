package com.example.foodzap.data.services.authentication

import com.example.foodzap.data.model.api_payload.SendOtpPayload
import com.example.foodzap.data.model.api_response.SendOtpResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


const val BASE_URL = "https://food-zap-backend.vercel.app/"
interface AuthenticationApiInterface {

    @POST("handleAuthentication/")
    suspend fun getOtp(@Body sendOtpPayload: SendOtpPayload) : Response<SendOtpResponse>
}

object AuthenticationService {
    val authenticationServiceInstance : AuthenticationApiInterface
    init {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        authenticationServiceInstance = retrofit.create(AuthenticationApiInterface::class.java)
    }
}