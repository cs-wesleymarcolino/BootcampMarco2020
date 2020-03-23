package br.com.bootcampmarco2020

import org.junit.Assert.assertFalse
import org.junit.Test

class PasswordValidatorTest {

    @Test
    fun givenPasswordIsShorterThan8_whenValidate_shouldReturnFalse() {
        val result = PasswordValidator().isValid("12345678")

        assertFalse(result)
    }
}