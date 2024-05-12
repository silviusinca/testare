package com.example.proiecttestare

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UITest {

    @Test
    fun testUIComponentsDisplayedCorrectly() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.editTextNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonCalculate)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonCube)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonReset)).check(matches(isDisplayed()))

        scenario.close()
    }

    @Test
    fun testUISquareCalculation() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.editTextNumber)).perform(ViewActions.typeText("5"))

        onView(withId(R.id.buttonCalculate)).perform(ViewActions.click())

        onView(withId(R.id.textViewResult)).check(matches(ViewMatchers.withText("25")))
        scenario.close()
    }

    @Test
    fun testUICubeCalculation() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.editTextNumber)).perform(ViewActions.typeText("5"))

        onView(withId(R.id.buttonCube)).perform(ViewActions.click())

        onView(withId(R.id.textViewResult)).check(matches(ViewMatchers.withText("125")))
        scenario.close()
    }

    @Test
    fun testReset() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.buttonReset)).perform(ViewActions.click())

        onView(withId(R.id.textViewResult)).check(matches(ViewMatchers.withText("")))
        scenario.close()
    }

    @Test
    fun testUIOnMoreNumbers() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.editTextNumber)).perform(ViewActions.typeText("98"))
        onView(withId(R.id.buttonCalculate)).perform(ViewActions.click())
        onView(withId(R.id.editTextNumber)).perform(ViewActions.clearText())

        onView(withId(R.id.editTextNumber)).perform(ViewActions.typeText("0"))
        onView(withId(R.id.buttonCalculate)).perform(ViewActions.click())
        onView(withId(R.id.editTextNumber)).perform(ViewActions.clearText())

        onView(withId(R.id.editTextNumber)).perform(ViewActions.typeText("-86"))
        onView(withId(R.id.buttonCube)).perform(ViewActions.click())
        onView(withId(R.id.editTextNumber)).perform(ViewActions.clearText())

        onView(withId(R.id.textViewResult)).check(matches(ViewMatchers.withText("-636056, 0, 9604")))
        scenario.close()
    }

}
