package br.com.bootcampmarco2020

import android.app.Activity
import android.app.Instrumentation
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*

class loginArrange(action: loginArrange.() -> Unit) {
    fun mockHomeActivityIntent() {
        intending(hasComponent(HomeActivity::class.java.name))
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))
    }

    init {
        action.invoke(this)
    }
}

class loginAct(action: loginAct.() -> Unit) {
    fun typePassword(password: String) {
        onView(withId(R.id.password))
            .perform(typeText(password))
    }

    fun typeUsername(username: String) {
        onView(withId(R.id.username))
            .perform(typeText(username))
    }

    fun clickLogin() {
        onView(withId(R.id.login))
            .perform(click())
    }

    init {
        action.invoke(this)
    }
}

class loginAssert(action: loginAssert.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun checkUsernameIsEmpty() {
        onView(withId(R.id.username))
            .check(matches(withText("")))
    }

    fun checkPasswordIsEmpty() {
        onView(withId(R.id.password))
            .check(matches(withText("")))
    }

    fun checkMessageWasShown(@StringRes messageRes: Int) {
        onView(withText(messageRes))
            .check(matches(isDisplayed()))
    }

    fun checkHomeActivityWasCalled() {
        intended(hasComponent(HomeActivity::class.java.name))
    }
}