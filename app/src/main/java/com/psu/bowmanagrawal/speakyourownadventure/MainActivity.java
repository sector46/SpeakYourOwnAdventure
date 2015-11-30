package com.psu.bowmanagrawal.speakyourownadventure;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.content.Intent;
import android.os.CountDownTimer;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.TimerTask;

import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;


public class MainActivity extends Activity {

    private SpeechRecognizer speechRecognizer;
    private String outputStr = "";
    private String generatedText = "";
    private int sceneNum;
    static final String TAG = "error_logger";

    private Scene scene;

    ImageButton speechButton; //= (ImageButton) findViewById(R.id.speech_button);
    ImageButton userInputButton;
    TextView textOutput; //= (TextView) findViewById(R.id.text_output);
    TextView userinputLabel;
    EditText userInputText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

        speechButton = (ImageButton) findViewById(R.id.speech_button);
        userInputButton = (ImageButton) findViewById(R.id.userInputConfirmButton);
        textOutput = (TextView) findViewById(R.id.text_output);
        userinputLabel = (TextView) findViewById(R.id.user_input_label);
        userInputText = (EditText) findViewById(R.id.user_input);

        sceneNum = 1;

        scene = new Scene();
        generatedText = SentenceGenerator.genIntroduction(scene);

        textOutput.setText(generatedText);


        final Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        RecognitionListener recognitionListener = new RecognitionListener() {
            @Override
            public void onResults(Bundle results) {
                ArrayList<String> voiceResults = results
                        .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                if (voiceResults == null) {
                    Log.e(TAG, "No voice results");
                    textOutput.setText(generatedText);
//                    textOutput.setText("No voice results");
                } else {
                    Log.d(TAG, "Printing matches: ");
                    for (String match : voiceResults) {
                        Log.d(TAG, match);
                    }
                    outputStr = voiceResults.get(0);
                    scene.genLocation();
                    scene.genEnemy();
                    generatedText = SentenceGenerator.genIntroduction(scene);
                    sceneNum += 1;
                    userinputLabel.setText("Scene " + sceneNum + ": " + outputStr);
                    textOutput.setText(generatedText);
//                    textOutput.setText(outputStr);
                }
            }

            @Override
            public void onReadyForSpeech(Bundle params) {
                Log.d(TAG, "Ready for speech");
            }

            @Override
            public void onError(int error) {
                Log.d(TAG,
                        "Error listening for speech: " + error);
            }

            @Override
            public void onBeginningOfSpeech() {
                Log.d(TAG, "Speech starting");
            }

            @Override
            public void onBufferReceived(byte[] buffer) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onEndOfSpeech() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onEvent(int eventType, Bundle params) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPartialResults(Bundle partialResults) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onRmsChanged(float rmsdB) {
                // TODO Auto-generated method stub

            }
        };

        speechRecognizer.setRecognitionListener(recognitionListener);

        OnTouchListener touchListener = new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()) {
                    // Start
                    case MotionEvent.ACTION_DOWN:
                        speechRecognizer.startListening(intent);
                        speechButton.getBackground().setColorFilter(getResources().getColor(R.color.Filter), PorterDuff.Mode.SRC_ATOP);
                        speechButton.invalidate();
                        break;
                        // End
                    case MotionEvent.ACTION_UP:
                        new CountDownTimer(500,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                               //  TODO AUTO-generated method stub

                            }
                            @Override
                            public void onFinish() {
                                speechRecognizer.stopListening();
                                speechButton.getBackground().clearColorFilter();
                                speechButton.invalidate();
                            }
                        }.start();
                    break;
                }
                return false;
            }
        };

        OnClickListener clickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                outputStr = userInputText.getText().toString();
                if(!outputStr.trim().isEmpty()) {
//                    textOutput.setText(outputStr);
                    scene.genLocation();
                    scene.genEnemy();
                    generatedText = SentenceGenerator.genIntroduction(scene);
                    sceneNum += 1;
                    userinputLabel.setText("Scene " + sceneNum + ": " + outputStr);
                    textOutput.setText(generatedText);
                    userInputText.setText("");
                }
            }
        };

        speechButton.setOnTouchListener(touchListener);
        userInputButton.setOnClickListener(clickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Used to hide keyboard
    // http://stackoverflow.com/questions/4005728/hide-default-keyboard-on-click-in-android/7241790#7241790
    // Last accessed 11/22/2015
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        View v = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);

        if (v instanceof EditText) {
            View w = getCurrentFocus();
            int scrcoords[] = new int[2];
            w.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + w.getLeft() - scrcoords[0];
            float y = event.getRawY() + w.getTop() - scrcoords[1];

            Log.d("Activity", "Touch event "+event.getRawX()+","+event.getRawY()+" "+x+","+y+" rect "+w.getLeft()+","+w.getTop()+","+w.getRight()+","+w.getBottom()+" coords "+scrcoords[0]+","+scrcoords[1]);
            if (event.getAction() == MotionEvent.ACTION_UP && (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w.getBottom()) ) {

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
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
