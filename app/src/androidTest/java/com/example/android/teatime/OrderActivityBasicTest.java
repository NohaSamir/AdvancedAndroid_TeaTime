package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by nsamir on 8/22/2019.
 */

@RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {

    @Rule
    public ActivityTestRule<OrderActivity> mOrderActivity = new ActivityTestRule<>(OrderActivity.class);


    @Test
    public void testIncrementButtonClick() {

        //Find view and perform action
        onView(withId(R.id.increment_button))
                .perform(click());

        //Check if the view what is expected
        onView(withId(R.id.quantity_text_view)).check(matches(withText("1")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$5.00")));

    }

    //check if cost updated when click increment button and then change size , First it failed
    // on size selected update cost displayCost(calculatePrice());  then success
    @Test
    public void onSizeChangePriceChange() {

        onView(withId(R.id.increment_button))
                .perform(click());

        onView(withId(R.id.tea_size_spinner))
                .perform(click());

        // use onData() which loads the adapter item we are interested in onto the screen before operating on it.
        onData(allOf(is(instanceOf(String.class)), is("Medium ($6/cup)"))).perform(click());

        onView(withId(R.id.tea_size_spinner)).check(matches(withSpinnerText("Medium ($6/cup)")));

        onView(withId(R.id.cost_text_view)).check(matches(withText("$6.00")));

    }


}
