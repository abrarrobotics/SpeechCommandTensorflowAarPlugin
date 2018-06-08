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

public class TestServiceActivity     {

    TextView outputText;
    static  String resultString = "EmptyCommand";
    static  Timer timer = null;

    static TestServiceActivity mInstance;

    static Activity myActivity;

    // Called From C# to get the Activity Instance
    public static void receiveActivityInstance(Activity tempActivity) {
        myActivity = tempActivity;
    }

    public static void StartServiceTestServiceActivityClass() {
        myActivity.startService(new Intent(myActivity, TestServiceActivity.class));
    }


    public static TestServiceActivity getmInstance() {
        return mInstance;
    }

    public  static String GetStr()
    {
        Log.d("wat?", "GetStr: " + resultString);
        return resultString;
    }


    public void startServiceClickedTensor() {
        if (timer == null) {
            timer = new Timer();
           // startService(new Intent(this, SpeechRecognitionService.class));
            Intent myIntent = new Intent(myActivity, SpeechRecognitionService.class);
            myActivity.startActivity(myIntent);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    myActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String res = SpeechRecognitionService.getmInstance().getRecognitionOutput();
                            Log.d("wat?", "startServiceClickedTensor: " + res);

                            outputText.setText(res);
                            resultString = outputText.getText().toString();
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
