package com.stoyan.doordashlite;

import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.stoyan.doordashlite.fragments.RestaurantListFrag;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by stoyan on 1/30/18.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RestaurantListTest {
    private IdlingForNetwork idlingResource;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void registerIntentServiceIdlingResource() {
        MainActivity activity = mActivityRule.getActivity();
        idlingResource = new IdlingForNetwork(activity);
        Espresso.registerIdlingResources(idlingResource);
    }



    @Test
    public void testRecycler() {
        MainActivity activity = mActivityRule.getActivity();
        RestaurantListFrag restaurantListFrag = (RestaurantListFrag) activity.getFragmentManager().findFragmentByTag(RestaurantListFrag.class.getSimpleName());
        assertNotNull(restaurantListFrag);
        assertTrue(restaurantListFrag.adapter.getItemCount() > 0);
    }


    @After
    public void unregisterIntentServiceIdlingResource() {
        Espresso.unregisterIdlingResources(idlingResource);
    }
}
