package app.test.pluginservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class TestServiceActivity {

    static String resultString = "EmptyCommand";


    static Activity myActivity;

    // Called From C# to get the Activity Instance
    public static void receiveActivityInstance(Activity tempActivity) {
        myActivity = tempActivity;
    }

    public static void StartServiceTestServiceActivityClass() {
        myActivity.startService(new Intent(myActivity, SpeechRecognitionService.class));
    }

    public static void openStartServiceActivity() {
        myActivity.startActivity(new Intent(myActivity, StartServiceActivity.class));
    }

    public static String GetStr() {
        resultString = SpeechRecognitionService.getmInstance().getRecognitionOutput();
        Log.d("wat?", "GetStr: " + resultString);
        return resultString;
    }

    public static void stopService() {
        SpeechRecognitionService.getmInstance().stopService();
    }
}
