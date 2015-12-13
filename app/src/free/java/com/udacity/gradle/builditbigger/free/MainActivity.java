package com.udacity.gradle.builditbigger.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.dc.jokedisplay.JokeDisplayActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.FetchJokeTask;
import com.udacity.gradle.builditbigger.R;

public class MainActivity extends ActionBarActivity implements FetchJokeTask.OnTaskCompleted {

    InterstitialAd mInterstitialAd;

    @Override
    public void onTaskCompleted(String joke) {
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.JOKE_KEY, joke);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.test_ad_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                fetchJoke();
            }
        });

        requestNewInterstitial();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void requestNewInterstitial() {
        Toast.makeText(this, "Requesting AD", Toast.LENGTH_SHORT).show();
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
//        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Button is clicked", Toast.LENGTH_SHORT).show();
        if(mInterstitialAd.isLoaded()){
            Toast.makeText(this, "This is an AD", Toast.LENGTH_SHORT).show();
            mInterstitialAd.show();
        }else{
            Toast.makeText(this, "joke is called", Toast.LENGTH_SHORT).show();
            fetchJoke();
        }

    }

    public void fetchJoke(){
        FetchJokeTask fetchJokeTask = new FetchJokeTask(this);
        fetchJokeTask.execute();
    }


}
