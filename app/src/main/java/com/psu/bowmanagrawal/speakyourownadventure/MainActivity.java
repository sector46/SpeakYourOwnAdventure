package com.psu.bowmanagrawal.speakyourownadventure;

import android.app.Activity;
import android.graphics.PorterDuff;
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

import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import android.widget.Toast;


public class MainActivity extends Activity {

    private SpeechRecognizer speechRecognizer;
    private String outputStr = "";
    private String generatedText = "";
    private int sceneNum;
    static final String TAG = "error_logger";

    private Scene scene;
    private Story story;

    private ImageButton speechButton; //= (ImageButton) findViewById(R.id.speech_button);
    private ImageButton userInputButton;
    private TextView textOutput; //= (TextView) findViewById(R.id.text_output);
    private TextView userinputLabel;
    private EditText userInputText;

    private Toast toast;

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

        toast=new Toast(this);
//        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);

        sceneNum = 1;

        scene = new Scene();
        story = new Story();

        generatedText = SentenceGenerator.genIntroduction(story, scene, true);
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
                    Toast.makeText(getApplicationContext(),
                        "Nothing was heard or typed!\nSay or type one verb!", Toast.LENGTH_LONG)
                        .show();

                } else {
                    Log.d(TAG, "Printing matches: ");
                    for (String match : voiceResults) {
                        Log.d(TAG, match);
                    }
                    outputStr = voiceResults.get(0);
                    postInput();
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
                Toast.makeText(getApplicationContext(),
                        "Nothing was heard or typed!\nSay or type one verb!", Toast.LENGTH_LONG)
                        .show();
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
                        if(story.isStillGoing()) {
                            speechRecognizer.startListening(intent);
                            speechButton.getBackground().setColorFilter(getResources().getColor(R.color.Filter), PorterDuff.Mode.SRC_ATOP);
                            speechButton.invalidate();
                        }

                        break;
                        // End
                    case MotionEvent.ACTION_UP:
                        if(story.isStillGoing()) {
                            new CountDownTimer(500, 1000) {
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
                        }
                    break;
                }
                return false;
            }
        };

        OnClickListener clickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(story.isStillGoing()) {
                    outputStr = userInputText.getText().toString();
                    outputStr = outputStr.split(" ", 2)[0];
                    if (!outputStr.trim().isEmpty()) {
//                    textOutput.setText(outputStr);
                        postInput();
                        userInputText.setText("");
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Nothing was heard or typed!\nSay or type one verb!", Toast.LENGTH_LONG)
                                .show();
                    }
                }
            }
        };

        speechButton.setOnTouchListener(touchListener);
        userInputButton.setOnClickListener(clickListener);
    }

    public void checkEnemyDefeated() {
        if(scene.getEnemy().isPassed()) {

            scene.genEnemy();
        }
    }

    public void postInput() {
        scene.setAction(outputStr);
        generatedText = SentenceGenerator.genSentences(story, scene); //SentenceGenerator.genIntroduction(scene);
        sceneNum += 1;
        userinputLabel.setText("Scene " + sceneNum + ": " + outputStr);
        textOutput.setText(generatedText);
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
