package br.com.bootcampmarco2020

class PasswordValidator {
    private val validations = listOf(
        "[a-z]",
        "[A-Z]",
        "[\\d]",
        "[\\W]",
        "[\\w\\W]{8,}"
    ).map { it.toRegex() }

    fun isValid(password: String) =
        password.isNotEmpty() &&
                validations.all { validation ->
                    password.contains(validation)
                }
}
