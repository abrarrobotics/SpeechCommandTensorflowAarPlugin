package app.test.pluginservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;

public class StartServiceActivity extends Activity {
    public static String TAG = "StartServiceActivity";

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.v(TAG, "onCreate: Starting the service now");
        Intent intent = new Intent(this, SpeechRecognitionService.class);
        startService(intent);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                StartServiceActivity.this.finish();
            }
        }, 2000);
    }
}
