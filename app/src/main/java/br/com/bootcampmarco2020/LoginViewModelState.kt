package br.com.bootcampmarco2020

sealed class LoginViewModelState {
    data class Error(val message: Int) : LoginViewModelState()
    object NavigateToHome : LoginViewModelState()
}
