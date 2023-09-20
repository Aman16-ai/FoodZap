package com.example.foodzap.utils

sealed class ApiHandler<T>(val data : T?,val message:String?) {

    class Success<T>(data: T) : ApiHandler<T>(data,message=null)
    class Error<T>(message:String,data:T?=null) : ApiHandler<T>(data=null,message=message)
    class Loading<T>:ApiHandler<T>(data=null,message=null)
}