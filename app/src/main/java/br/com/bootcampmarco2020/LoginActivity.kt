package br.com.bootcampmarco2020

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    private val loginViewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(PasswordValidator())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel.getViewState().observe(this, Observer {
            when (it) {
                is LoginViewModelState.Error -> showError(it.message)
                is LoginViewModelState.NavigateToHome -> navigateToHome()
            }
        })

        login.setOnClickListener {
            loginViewModel.validateLogin(
                username.text.toString(),
                password.text.toString()
            )
        }
    }

    private fun showError(@StringRes errorRes: Int) {
        AlertDialog.Builder(this)
            .setMessage(errorRes)
            .show()
    }

    private fun navigateToHome() {
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        startActivity(intent)
    }
}