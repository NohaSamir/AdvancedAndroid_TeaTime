package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.teatime.model.Tea;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;

@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {

    @Rule
    public ActivityTestRule<MenuActivity> mMenuActivity = new ActivityTestRule<>(MenuActivity.class);


    @Test
    public void onGridItemClick_OpenOrderActivity() {

        //onData takes an object matcher - it's intended to match the custom model object that is used to populate the list
       /* onData(instanceOf(Tea.class)).atPosition(0).perform(click());
        onView(withId(R.id.tea_name_text_view)).check(matches(withText("Black Tea")));
*/
        //OR
        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(1).perform(click());
        onView(withId(R.id.tea_name_text_view)).check(matches(withText("Green Tea")));




    }
}
