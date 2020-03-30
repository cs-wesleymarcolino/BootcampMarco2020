package br.com.bootcampmarco2020

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val mockedPasswordValidator = mockk<PasswordValidator>()
    private val loginViewModel = LoginViewModel(mockedPasswordValidator)

    @Test
    fun givenInvalidPassword_whenValidatingPassword_shouldEmitError() {
        every { mockedPasswordValidator.isValid(any()) } returns false

        loginViewModel.validateLogin("email", "password")

        assertEquals(
            loginViewModel.getViewState().value,
            LoginViewModelState.Error(R.string.generic_login_error)
        )
    }

    @Test
    fun givenValidPassword_whenValidatingPassword_shouldNavigateToHome() {
        every { mockedPasswordValidator.isValid(any()) } returns true

        loginViewModel.validateLogin("email", "password")

        assertEquals(
            loginViewModel.getViewState().value,
            LoginViewModelState.NavigateToHome
        )
    }
}