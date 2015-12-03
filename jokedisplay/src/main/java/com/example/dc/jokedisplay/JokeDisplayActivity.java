package com.example.dc.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "JOKE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

    }
}
