package com.example.foodzap.ui.auth.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodzap.data.model.api_payload.SendOtpPayload
import com.example.foodzap.data.model.api_response.SendOtpResponse
import com.example.foodzap.data.repository.Authentication.AuthRepo
import com.example.foodzap.data.repository.Authentication.AuthRepoImp
import com.example.foodzap.utils.ApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MobileNumberViewModel : ViewModel() {

    private var _getOtpStatus : MutableLiveData<ApiHandler<SendOtpResponse?>> = MutableLiveData()
    val getOtpStatus : LiveData<ApiHandler<SendOtpResponse?>>
        get() = _getOtpStatus

    val authRepo : AuthRepo = AuthRepoImp()

    fun getOtp(sendOtpPayload: SendOtpPayload) {
        viewModelScope.launch {
            val loading = ApiHandler.Loading<SendOtpResponse?>()
            _getOtpStatus.postValue(loading)
            val result : SendOtpResponse? = withContext(Dispatchers.IO) {
                authRepo.getOtp(sendOtpPayload)
            }
            Log.d("auth", "getOtp: "+result.toString())
            val success = ApiHandler.Success<SendOtpResponse?>(data = result)
            _getOtpStatus.postValue(success)
        }
    }
}