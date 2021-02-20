package com.example.unitcoverter;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.unitcoverter", appContext.getPackageName());
    }

    @Test
    public void should_not_enter_empty_input() {
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_output)).check(matches(withText("")));
    }

    @Test
    public void can_enter_apples() {
        onView(withId(R.id.converter_input)).perform(typeText("45"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_output)).check(matches(withText("48.00 Oranges")));
    }

    @Test
    public void can_enter_pounds() {
        onView(withId(R.id.spinner)).perform(click());
        onView(withText("Pounds to Kilograms")).perform(click());
        onView(withId(R.id.converter_input)).perform(typeText("100"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_output)).check(matches(withText("45.36 Kg")));
    }

    @Test
    public void can_enter_ounces() {
        onView(withId(R.id.spinner)).perform(click());
        onView(withText("Fluid Ounces to Milliliters")).perform(click());
        onView(withId(R.id.converter_input)).perform(typeText("100"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_output)).check(matches(withText("2957.40 ml")));
    }

    @Test
    public void can_enter_meters() {
        onView(withId(R.id.spinner)).perform(click());
        onView(withText("Meters to Feet")).perform(click());
        onView(withId(R.id.converter_input)).perform(typeText("100"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converter_output)).check(matches(withText("328.10 Feet")));
    }
}