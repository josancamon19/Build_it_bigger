package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

/**
 * Created by Matteo on 30/06/2015.
 */
public class StringReceivedTest extends AndroidTestCase {

    private static final String LOG_TAG = StringReceivedTest.class.getSimpleName();

    @SuppressWarnings("unchecked")
    public void test() {

        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext());
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }

}
