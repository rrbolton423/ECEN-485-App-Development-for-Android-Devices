package com.romellbolton.threadapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

    // Declare the Progress Bar
    private ProgressBar mProgressBar;

    // Declare the Button view
    private Button mStartBtn;

    // Declare the Thread object
    private Thread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the progress bar
        mProgressBar = (ProgressBar) findViewById(R.id.progressBarThread);

        // Instantiate the button
        mStartBtn = (Button) findViewById(R.id.startBtnThread);

        // Set a Listener on the Button
        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Call startProgress when the button is clicked,
                // passing the view that started the operation
                startProgress(view);
            }
        });
    }

    public void startProgress(View view) {

        // Set the progress of the progress bar to 0
        mProgressBar.setProgress(0);

        // Instantiate a
        mThread = new Thread() {
            @Override
            public void run() {

                // Perform thread commands...
                // Load the progress bar 10 times
                for (int i = 0; i <= 10; i++) {

                    try {

                        // Suspend the thread once to show the progress bar loading
                        Thread.sleep(1000);

                    } catch (InterruptedException e) { // Catch exception

                        // Print error
                        e.printStackTrace();
                    }

                    // Set the progress bar as "i" increases 10 times in the loop
                    mProgressBar.setProgress(i);
                }

                // Call the stopThread() method.
                stopThread(this);
            }
        };

        // Start the thread after it's creation
        mThread.start();
    }

    private synchronized void stopThread(Thread theThread) {

        // If the thread isn't already equal to null
        if (theThread != null) {
            // Set the thread equal to null
            theThread = null;
        }
    }
}
