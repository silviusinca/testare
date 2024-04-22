package com.example.proiecttestare

import android.annotation.SuppressLint
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@SuppressLint("DiscouragedPrivateApi", "SoonBlockedPrivateApi")
@LargeTest
@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSquareCalculationAndDisplay() {
        onView(withId(R.id.editTextNumber)).perform(replaceText("5"))
        onView(withId(R.id.buttonCalculate)).perform(click())
        onView(withId(R.id.textViewResult)).check(matches(withText("25")))
    }

}

///TO DO
///strategie de testare, mai multe tipuri
///comparatie mai detaliata intre cele 2 framework uri
///raport de testare (cat la suta s a executat, ce linii nu s au executat etc.
///diferenta intre ce am facut noi si ce genereaza AI ul ?
///PPT
///alt tool de testare? -> generare de mutanti??