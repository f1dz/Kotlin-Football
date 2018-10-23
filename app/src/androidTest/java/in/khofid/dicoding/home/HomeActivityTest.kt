package `in`.khofid.dicoding.home

import `in`.khofid.dicoding.R
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {
    @Rule
    @JvmField var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun testAppBehaviour() {

        var fav = false

        onView(withId(R.id.spinner)).check(matches(isDisplayed()))
        onView(withId(R.id.spinner)).perform(click())
        onView(withText("Spanish La Liga")).perform(click())


        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
        onView(withText("Barcelona")).check(matches(isDisplayed()))
        onView(withText("Barcelona")).perform(click())

        onView(withId(R.id.add_to_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.add_to_favorite)).perform(click())
        try {
            onView(withText("Added to favorite")).check(matches(isDisplayed()))
            fav = true
        } catch (e: Exception){
            onView(withText("Removed from favorite")).check(matches(isDisplayed()))
            fav = false
        }

        Espresso.pressBack()

        onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()))

        onView(withId(R.id.favorites)).perform(click())
        if(fav) onView(withText("Barcelona")).check(matches(isDisplayed()))
    }
}