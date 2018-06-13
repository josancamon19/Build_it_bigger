package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;
import android.util.Pair;

import com.example.supplyjokes.Joke;

import static android.content.ContentValues.TAG;


public class StringReceivedTest extends AndroidTestCase {

    private static final String LOG_TAG = StringReceivedTest.class.getSimpleName();

    @SuppressWarnings("unchecked")
    public void test() throws Exception {

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext());

        endpointsAsyncTask.execute();
        String result = endpointsAsyncTask.get();
        Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);

        assertNotNull(result);
    }
}
