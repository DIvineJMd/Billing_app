package com.example.billingapp

data class LoginState(
    val isSignInSuccessfully: Boolean=false,
    val signinError:String?=null
)
