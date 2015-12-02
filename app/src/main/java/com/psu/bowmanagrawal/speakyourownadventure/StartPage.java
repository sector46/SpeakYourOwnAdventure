package com.psu.bowmanagrawal.speakyourownadventure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by shweta on 11/25/2015.
 */
public class StartPage extends Activity {
    Button startButton;
    Button creditsButton;
    Intent startIntent;
    Intent creditsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        startButton  = (Button) findViewById(R.id.start_button);
        creditsButton = (Button) findViewById(R.id.credits_button);

        startIntent = new Intent(this, MainActivity.class);
        creditsIntent = new Intent(this, Credits.class);

        View.OnClickListener startListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(startIntent);
            }
        };

        View.OnClickListener creditsListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(creditsIntent);
            }
        };

        // ListView Item Click Listener
        startButton.setOnClickListener(startListener);
        creditsButton.setOnClickListener(creditsListener);
    }

}