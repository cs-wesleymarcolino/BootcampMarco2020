package br.com.bootcampmarco2020

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val activityRule = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun givenInitialState_ShouldHaveEmptyUsernameAndPassword() {
        loginAssert {
            checkUsernameIsEmpty()
            checkPasswordIsEmpty()
        }
    }

//    @Test
//    fun givenUsernameIsEmpty_whenLogin_shouldShowEmptyUsernameError() {
//        loginAct {
//            typePassword("abCD@3223233")
//
//            clickLogin()
//        }
//
//        loginAssert {
//            checkMessageWasShown(R.string.generic_login_error)
//        }
//    }

    @Test
    fun givenPasswordIsEmpty_whenLogin_shouldShowEmptyPasswordError() {
        loginAct {
            typeUsername("wesjon")

            clickLogin()
        }

        loginAssert {
            checkMessageWasShown(R.string.generic_login_error)
        }
    }

    @Test
    fun givenPasswordIsInvalid_whenLogin_shouldShowInvalidPasswordError() {
        loginAct {
            typeUsername("wesjon")
            typePassword("aabccc")

            clickLogin()
        }

        loginAssert {
            checkMessageWasShown(R.string.generic_login_error)
        }
    }

    @Test
    fun givenUsernameAndPasswordAreValid_whenLogin_shouldGoToHomeActivity() {

        loginArrange {
            mockHomeActivityIntent()
        }

        loginAct {
            typeUsername("wesjon")
            typePassword("aA323!!@bccc")

            clickLogin()
        }

        loginAssert {
            checkHomeActivityWasCalled()
        }
    }
}