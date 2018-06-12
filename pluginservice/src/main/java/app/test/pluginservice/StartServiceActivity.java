package app.test.pluginservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class StartServiceActivity extends Activity {
    public static String TAG = "StartServiceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.v(TAG, "onCreate: Starting the service now");
        Intent intent = new Intent(this, SpeechRecognitionService.class);
        startService(intent);
        finish();
    }
}
