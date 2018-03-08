package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.example.displayjoke.DisplayJokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.backend.jokeApi.model.MyJoke;

import java.io.IOException;

import static android.content.ContentValues.TAG;

/**
 * Created by Santiago on 4/03/2018.
 */

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static JokeApi myApiService = null;
    private Context context;
    public EndpointsAsyncTask(Context context){
        this.context = context;
    }
    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }
        //context = params[0].first;
        try {
            Log.d(TAG, "onPostExecute:  "+myApiService.putJoke(new MyJoke()).execute().getData());
            return myApiService.putJoke(new MyJoke()).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Log.d(TAG, "onPostExecute:  "+result);

        Intent intent = new Intent(context, DisplayJokeActivity.class);
        intent.putExtra("joke",result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
