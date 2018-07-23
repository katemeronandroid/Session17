package com.emarkova.session17;

import android.app.Application;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class CorrectInputTest {
    @Rule
    public ActivityTestRule<ActivityCreate> activityCreateTestRule = new ActivityTestRule<>(ActivityCreate.class);

    @Test
    public void correctInput() throws Exception {
        //check fields
        onView(withId(R.id.editText)).check(matches(isDisplayed()));
        onView(withId(R.id.editText2)).check(matches(isDisplayed()));
        onView(withId(R.id.editText3)).check(matches(isDisplayed()));
        onView(withId(R.id.editText)).perform(replaceText("Фамилия"), closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(replaceText("Имя"), closeSoftKeyboard());
        onView(withId(R.id.editText3)).perform(replaceText("Отчество"), closeSoftKeyboard());
        //check button
        onView(withId(R.id.button)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).perform(click());
        //check main activity
        onView(withId(R.id.lessonRecyclerList)).check(matches(isDisplayed()));
        onView(withId(R.id.my_toolbar)).check(matches(isDisplayed()));
        //check item
        int position = (new DataManager(MyApplication.getContext())).getCounter() - 1;
        onView(withId(R.id.lessonRecyclerList)).check(matches(isDisplayed()));
        onView(withId(R.id.lessonRecyclerList)).perform(RecyclerViewActions.scrollToPosition(position));
        onView(withId(R.id.lessonRecyclerList)).perform(RecyclerViewActions.actionOnItemAtPosition(position, click()));
        //check detail activity
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.textView2)).check(matches(isDisplayed()));
        onView(withId(R.id.textView2)).check(matches(withText("Фамилия Имя Отчество")));
    }
}
