package com.example.android.butterknifeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // Create TAG for logging
    private static final String TAG = "MainActivity";

    // Declare TextView
    private TextView mLog;

//    Create an instance of the runButton using ButterKnife syntax
//    @BindView(R.id.run_button)
//    Button runButton;

    // Get a reference to a view and event handle
    // directly with ButterKnife syntax by setting up the annotations
    // and methods atop of the class, and include the call to
    // ButterKnife.bind(this) after loading the layout.
    @OnClick(R.id.clear_button)
    public void onClearButtonClick() {
        // Clear the Text and reset the scroll position
        mLog.setText("");
        mLog.scrollTo(0, 0);
    }

    // Get a reference to a view and event handle
    // directly with ButterKnife syntax by setting up the annotations
    // and methods atop of the class, and include the call to
    // ButterKnife.bind(this) after loading the layout.
    @OnClick(R.id.run_button)
    public void onRunButtonClick() {
        // Log runCode message
        logMessage("runCode");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call the bind() method of the ButterKnife class, which
        // generates code in the background and allows you to refer to
        // all of the other capabilities of ButterKnife
        ButterKnife.bind(this);

        // Get reference to TextView
        mLog = (TextView) findViewById(R.id.log);

        // Turn on vertical scrolling
        mLog.setMovementMethod(new ScrollingMovementMethod());

        // Clear the Text
        mLog.setText("");

        // Log create message
        logMessage("onCreate");
    }

    private void logMessage(String message) {
//      Output message to logcat console
        Log.i(TAG, message);

//      Output message to TextView
        mLog.append(message + "\n");

//      Adjust scroll position to make last line visible
        Layout layout = mLog.getLayout();
        if (layout != null) {
            int scrollAmount = layout.getLineTop(mLog.getLineCount()) - mLog.getHeight();
            mLog.scrollTo(0, scrollAmount > 0 ? scrollAmount : 0);
        }
    }
}


