package com.michelAdrien.AMTT0121

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.michelAdrien.AMTT0121.View.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class AppBarTest {

    @get:Rule
    val mainActivityTestRule : ActivityTestRule<MainActivity> = ActivityTestRule<MainActivity>(
            MainActivity::class.java
    )

    //App bar have been correctly loaded
    @Test
    fun loadedAppBar(){
        onView(withId(R.id.main_toolbar)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    //The menu that goes to profile fragment has been correctly loaded
    @Test
    fun loadedMenu(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext())
        onView(withText("Profil")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun goToProfile(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext())
        onView(withText("Profil")).perform(click())
        onView(withId(R.id.profileLayout)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun comeBack(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext())
        onView(withText("Profil")).perform(click())
        onView(withId(R.id.profileLayout)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        pressBack()
        onView(withId(R.id.list_device_layout)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}