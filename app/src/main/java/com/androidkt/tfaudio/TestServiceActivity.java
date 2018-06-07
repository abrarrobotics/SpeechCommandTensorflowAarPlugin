package com.androidkt.tfaudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import app.test.pluginservice.SpeechRecognitionService;

public class TestServiceActivity extends AppCompatActivity {

    TextView outputText;
    Timer timer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service);
        outputText = findViewById(R.id.outputTV);


    }

    public void startServiceClicked(View view) {
        if (timer == null) {
            timer = new Timer();
            startService(new Intent(this, SpeechRecognitionService.class));
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String res = SpeechRecognitionService.getmInstance().getRecognitionOutput();
                            outputText.setText(res);
                        }
                    });
                }
            }, 1000, 1000);
        }
    }

    public void stopServiceClicked(View view) {
        if (timer != null) {
            timer.cancel();
            timer = null;
            SpeechRecognitionService.getmInstance().stopService();
        }

    }
}
