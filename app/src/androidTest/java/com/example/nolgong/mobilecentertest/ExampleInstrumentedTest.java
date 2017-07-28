package com.example.nolgong.mobilecentertest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.nolgong.mobilecentertest", appContext.getPackageName());
    }

    @Test
    public void btn_Test(){
        // 로그인 버튼 클릭.
        onView(withId(R.id.first)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.back)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.second)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.back)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.third)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.back)).perform(click()).check(matches(isDisplayed()));


    }


}

