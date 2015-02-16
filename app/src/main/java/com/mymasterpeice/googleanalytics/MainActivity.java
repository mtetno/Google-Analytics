package com.mymasterpeice.googleanalytics;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mymasterpeice.helper.GoogleAnalyticsHelper;


public class MainActivity extends Activity {

    private GoogleAnalyticsHelper mGoogleHelper;
    private Button mTrackButton;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrackButton = (Button) findViewById(R.id.bt_track1);

        mTrackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SendEventGoogleAnalytics("Button", "click----event",
                        "Track Button click");
                Log.d(TAG, "sended Button event on GA");
                Toast.makeText(MainActivity.this, "sended Button event on GA", Toast.LENGTH_LONG).show();
            }
        });

        InitGoogleAnalytics();
        SendScreenNameGoogleAnalytics();
        Toast.makeText(MainActivity.this, "sended screen-views on GA", Toast.LENGTH_LONG).show();
    }

    private void InitGoogleAnalytics() {
        mGoogleHelper = new GoogleAnalyticsHelper();
        mGoogleHelper.init(MainActivity.this);
    }

    private void SendScreenNameGoogleAnalytics() {

        mGoogleHelper.SendScreenNameGoogleAnalytics("MainActivity", MainActivity.this);
    }

    private void SendEventGoogleAnalytics(String iCategoryId, String iActionId, String iLabelId) {

        mGoogleHelper.SendEventGoogleAnalytics(MainActivity.this, iCategoryId, iActionId, iLabelId);
    }
}
