package com.example.foodzap.data.model.api_response

data class SendOtpResponse(
    val status:Boolean,
    val Response:UserData
) {
    data class UserData (
        val _id:String,
        val firstName:String,
        val lastName:String,
        val phoneNo : String,
        val __v :Int
    )
}
