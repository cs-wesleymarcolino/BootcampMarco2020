package br.com.bootcampmarco2020

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {
    private val passwordValidator = PasswordValidator()

    @Test
    fun givenPasswordIsShorterThan8_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("aBd32!")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntContainUppercaseLetter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("abcd123!!@")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntContainLowercaseLetter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("ABCD123!!@")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntContainANumber_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("ABCDcfdf!!@")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntContainASpecialCharacter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("ABCDcfdf323")

        assertFalse(result)
    }

    @Test
    fun givenPasswordIsValid_whenValidate_shouldReturnTrue() {
        val result = passwordValidator.isValid("abcdDEas@!@!2133")

        assertTrue(result)
    }
}