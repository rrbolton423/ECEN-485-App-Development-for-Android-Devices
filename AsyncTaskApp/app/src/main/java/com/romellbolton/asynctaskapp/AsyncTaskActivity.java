package com.romellbolton.asynctaskapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Have class implement OnClickListener
public class AsyncTaskActivity extends Activity implements View.OnClickListener {

    // Define Button and TextView
    TextView txt;
    Button btnRun;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate TextView and Button
        txt = (TextView) findViewById(R.id.tv_output);
        btnRun = (Button) findViewById(R.id.btn_run);

        // Set listener on the button
        // Because we implement OnClickListener we only have to pass "this"
        btnRun.setOnClickListener(this);
    }

    public void onClick(View view) {

        // Detect the view that was "clicked"
        switch (view.getId()) {

            // When the run button is clicked
            case R.id.btn_run:

                // Change the text before the Task run
                txt.setText("Executing...");

                // Execute the AsyncTask
                new LongOperation().execute("");

                // Break from switch statement
                break;
        }
    }

    // Create AsyncTask class
    private class LongOperation extends AsyncTask<String, Void, String> {

        // Override doInBackground() method which executes on a separate thread
        @Override
        protected String doInBackground(String... params) {

            // For 5 times...
            for (int i = 0; i < 5; i++) {

                try {
                    // Sleep the Thread fro 1 second
                    Thread.sleep(1000);

                    // Exception handle
                } catch (InterruptedException e) {

                    // Exception handle
                    Thread.interrupted();
                }
            }

            // Return an "Executed!" String
            return "Executed!";
        }

        // Override AsyncTask's onPostExecute() method
        @Override
        protected void onPostExecute(String result) {

            // Change text once Task completes
            txt.setText(result);
        }

        // Override AsyncTask's onPreExecute() method
        @Override
        protected void onPreExecute() {}

        // Override AsyncTask's onProgressUpdate() method
        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}
