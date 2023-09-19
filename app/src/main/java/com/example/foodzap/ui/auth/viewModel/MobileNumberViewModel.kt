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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MobileNumberViewModel : ViewModel() {

    private var _getOtpStatus : MutableLiveData<Boolean> = MutableLiveData()
    val getOtpStatus : LiveData<Boolean>
        get() = _getOtpStatus

    val authRepo : AuthRepo = AuthRepoImp()

    fun getOtp(sendOtpPayload: SendOtpPayload) {
        viewModelScope.launch {
            val result : SendOtpResponse? = withContext(Dispatchers.IO) {
                authRepo.getOtp(sendOtpPayload)
            }
            Log.d("auth", "getOtp: "+result.toString())
        }
    }
}