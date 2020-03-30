package br.com.bootcampmarco2020

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(
    private val passwordValidator: PasswordValidator
) : ViewModel() {

    private val state = MutableLiveData<LoginViewModelState>()

    fun getViewState(): LiveData<LoginViewModelState> = state

    fun validateLogin(
        email: String,
        password: String
    ) {
        val isPasswordValid = passwordValidator.isValid(password)

        if (isPasswordValid) {
            state.value = LoginViewModelState.NavigateToHome
        } else {
            state.value = LoginViewModelState.Error(R.string.generic_login_error)
        }
    }
}
