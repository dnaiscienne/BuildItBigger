package com.example.dc.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "JOKE_KEY";
    String mJokeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        TextView jokeView = (TextView) findViewById(R.id.joke_textview);

        if (savedInstanceState != null){
            mJokeText = savedInstanceState.getString(JOKE_KEY, getString(R.string.no_joke));
        }else{
            mJokeText = getIntent().getStringExtra(JOKE_KEY);
        }
        if(mJokeText != null && mJokeText.length() != 0){
            jokeView.setText(mJokeText);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(JOKE_KEY, mJokeText);
        super.onSaveInstanceState(outState);
    }
}
