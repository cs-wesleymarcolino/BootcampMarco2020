package br.com.bootcampmarco2020

class PasswordValidator {
    fun isValid(password: String): Boolean {
        return password.length >= 8
    }
}
