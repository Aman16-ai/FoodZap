package com.example.foodzap.data.model.api_response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData (
    val _id:String,
    val firstName:String,
    val lastName:String,
    val phoneNo : String,
    val __v :Int
):Parcelable
@Parcelize
data class SendOtpResponse(
    val status:Boolean,
    val Response:UserData
):Parcelable

