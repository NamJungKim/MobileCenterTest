package com.example.nolgong.mobilecentertest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.xamarin.testcloud.espresso.Factory;
import com.xamarin.testcloud.espresso.ReportHelper;

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

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.nolgong.mobilecentertest", appContext.getPackageName());
    }

    @Test
    public void first_Test(){
        // 로그인 버튼 클릭.
        reportHelper.label("MainActivity");
        onView(withId(R.id.first)).perform(ViewActions.click());
        reportHelper.label("FisrtActivity");
        onView(withId(R.id.back)).perform(ViewActions.click());
        reportHelper.label("MainActivity");
    }
    @Test
    public void second_Test(){
        reportHelper.label("MainActivity");
        onView(withId(R.id.second)).perform(ViewActions.click());
        reportHelper.label("SecondActivity");
        onView(withId(R.id.back)).perform(ViewActions.click());
        reportHelper.label("MainActivity");
    }
    @Test
    public void third_Test(){
        reportHelper.label("MainActivity");
        onView(withId(R.id.third)).perform(ViewActions.click());
        reportHelper.label("ThirdActivity");
        onView(withId(R.id.back)).perform(ViewActions.click());
        reportHelper.label("MainActivity");
    }


}

