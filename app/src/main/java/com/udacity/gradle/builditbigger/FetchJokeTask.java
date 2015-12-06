package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.example.dc.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by D.C on 12/4/2015.
 */
public class FetchJokeTask extends AsyncTask<Context, Void, String> {

    public interface OnTaskCompleted{
        void onTaskCompleted(String joke);
    }

    private final String LOG_TAG = FetchJokeTask.class.getSimpleName();
    private OnTaskCompleted listener;

    public FetchJokeTask(OnTaskCompleted listener){
        this.listener =listener;
    }

    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokebackend.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        listener.onTaskCompleted(result);
    }
}
