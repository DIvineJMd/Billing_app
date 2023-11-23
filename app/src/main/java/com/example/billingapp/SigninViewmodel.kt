package com.example.billingapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SigninViewmodel:ViewModel() {
    private val  _state = MutableStateFlow(LoginState())
    val state =_state.asStateFlow()

    fun onSignInResult(result: SignInData){
        _state.update { it.copy(isSignInSuccessfully = result.data !=null,
            signinError=result.errorMessage
            )
        }
    }
    fun resetState(){
        _state.update { LoginState() }
    }


}