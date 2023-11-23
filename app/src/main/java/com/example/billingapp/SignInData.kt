package com.example.billingapp

data class SignInData(
    val data: UserData?,
    val errorMessage: String?)
data class UserData(
    val userId: String,
    val username: String?,
    val profilePictureUrl: String?)

