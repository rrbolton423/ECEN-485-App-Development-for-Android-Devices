package com.romellbolton.switchapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Define both Switches
    Switch simpleSwitch1, simpleSwitch2;

    // Define Button
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initiate View's
        simpleSwitch1 = (Switch) findViewById(R.id.simpleSwitch1);
        simpleSwitch2 = (Switch) findViewById(R.id.simpleSwitch2);
        submit = (Button) findViewById(R.id.submitButton);

        // Add click listener on button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create String value of switches
                String statusSwitch1, statusSwitch2;

                // If switch 1 is checked...
                if (simpleSwitch1.isChecked()) {

                    // Get the "ON" String status of switch 1 for display
                    statusSwitch1 = simpleSwitch1.getTextOn().toString();

                    // If switch 1 is NOT checked...
                } else {

                    // Get the "OFF" String status of switch 1 for display
                    statusSwitch1 = simpleSwitch1.getTextOff().toString();
                }

                // If switch 2 is checked...
                if (simpleSwitch2.isChecked()) {

                    // Get the "ON" String status of switch 2 for display
                    statusSwitch2 = simpleSwitch2.getTextOn().toString();

                    // If switch 2 is NOT checked...
                } else {

                    // Get the "OFF" String status of switch 2 for display
                    statusSwitch2 = simpleSwitch2.getTextOff().toString();
                }

                // Display the status of both switches being on or off via Toast message
                Toast.makeText(getApplicationContext(), "Switch1 :" + statusSwitch1 + "\n" + "Switch2 :" + statusSwitch2, Toast.LENGTH_LONG).show(); // display the current state for switch's
            }
        });
    }
}
