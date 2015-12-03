package com.example.dc.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "JOKE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        TextView jokeView = (TextView) findViewById(R.id.joke_textview);

        String jokeString = getIntent().getStringExtra(JOKE_KEY);
        if(jokeString != null && jokeString.length() != 0){
            jokeView.setText(jokeString);
        }
    }
}
