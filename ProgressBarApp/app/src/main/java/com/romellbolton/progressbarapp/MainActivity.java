package com.romellbolton.progressbarapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Define ProgressBar
    private ProgressBar progressBar;

    // Define int value representing the progress status of the ProgressBar
    private int progressStatus = 0;

    // Define TextView
    private TextView textView;

    // Instantiate Handler
    // Used to communicate between the UI and Background thread.
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate Views
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.textView);

        /* Start long running operation in a background thread */

        // Create a new Thread
        new Thread(new Runnable() {

            // Implement the run() method of the Runnable interface
            @Override
            public void run() {

                // Until the progress status is 100...
                while (progressStatus < 100) {

                    // Increment the progress status variable
                    progressStatus += 1;

                    /* Update the ProgressBar and display the
                       current value in the text view */

                    // Use the Handler object to add the Runnable to the message queue
                    handler.post(new Runnable() {

                        @Override
                        public void run() {

                            // Set the progress of the progressBar
                            progressBar.setProgress(progressStatus);

                            // Display the progress status of the ProgressBar
                            textView.setText(progressStatus+"/"+progressBar.getMax());
                        }
                    });

                    // Try to..
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);

                        // InterruptedException handle
                    } catch (InterruptedException e) {

                        // Print the stack trace
                        e.printStackTrace();
                    }
                }
            }
        }).start(); // Start the thread
    }
}
