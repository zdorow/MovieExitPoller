package com.example.worldcom.movieexitpoller;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.worldcom.movieexitpoller.Activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.worldcom.movieexitpoller", appContext.getPackageName());
    }

    @Test
    public void submit(){
        onView(withId(R.id.recyclerview_main))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.radioButton1)).perform(click());
        onView(withId(R.id.radioButton2_1)).perform(click());
        onView(withId(R.id.radioButton3_1)).perform(click());
        onView(withId(R.id.radioButton4_1)).perform(click());
        onView(withId(R.id.radioButton5_1)).perform(click());
        onView(withId(R.id.radioButton6_1)).perform(click());

        // Errors out with scrollTo()
        onView(withId(R.id.nestedScrollView)).perform(swipeUp(), click());
    }
}
