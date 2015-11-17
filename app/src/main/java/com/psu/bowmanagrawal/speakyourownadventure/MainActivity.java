package com.psu.bowmanagrawal.speakyourownadventure;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends Activity implements OnTouchListener {

    private SpeechRecognizer speechRecognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        ImageButton speechButton = (ImageButton) findViewById(R.id.speech_button);
        final Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        OnTouchListener touchListener = new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Start
                        speechRecognizer.startListening(intent);
                        break;
                    case MotionEvent.ACTION_UP:
                        // End
                        speechRecognizer.stopListening();
                        break;
                }
                return false;
            }
        };

        speechButton.setOnTouchListener(touchListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Start
                break;
            case MotionEvent.ACTION_UP:
                // End
                break;
        }
        return false;
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
}
