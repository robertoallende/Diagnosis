package com.robertoallende.diagnosis;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;

import com.robertoallende.diagnosis.view.DiagnosisActivity;

@RunWith(AndroidJUnit4.class)
public class DiagnosisTest {

    @Rule
    public ActivityTestRule<DiagnosisActivity> mDiagnosisActivityTestRule =
            new ActivityTestRule<DiagnosisActivity>(DiagnosisActivity.class);

    @Test
    public void emptyCase() {
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.question_activity)).check(matches(isDisplayed()));
        onView(withId(R.id.choice_1)).perform(click());

        onView(withId(R.id.question_activity)).check(matches(isDisplayed()));
        onView(withId(R.id.choice_2)).perform(click());

        onView(withId(R.id.question_activity)).check(matches(isDisplayed()));
        onView(withId(R.id.choice_1)).perform(click());

        onView(withId(R.id.question_activity)).check(matches(isDisplayed()));
        onView(withId(R.id.choice_1)).perform(click());

        onView(withId(R.id.result_activity)).check(matches(isDisplayed()));
        onView(withId(R.id.close_result)).perform(click());

        onView(withId(R.id.diagnosis_activity)).check(matches(isDisplayed()));


    }
}

