package com.romellbolton.seekbarapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Declare SeekBar and TextView
    private SeekBar seekBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize variables
        initializeVariables();

        // Initialize the textview with '0'.
        textView.setText("Covered: " + seekBar.getProgress() + "/" + seekBar.getMax());

        // Set a OnSeekBarChangeListener on the SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // Create variable to track the progress
            int progress = 0;

            // onStartTrackingTouch() is called when a gesture is changed on the SeekBar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {

                // Set the progress of the change on the SeekBar
                progress = progressValue;

                // Display seek changed toast message
                Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            // onStartTrackingTouch() is called when a gesture is started on the SeekBar
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                // Display seek started toast message
                Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            // onStopTrackingTouch() is called when a gesture is stopped on the SeekBar
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                // Display the progress the SeekBar made when the gesture stops
                textView.setText("Covered: " + progress + "/" + seekBar.getMax());

                // Display seek stopped toast message
                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // A private method to help us initialize our variables.
    private void initializeVariables() {

        // Instantiate the views
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        textView = (TextView) findViewById(R.id.textView1);
    }
}
