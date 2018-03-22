package com.romellbolton.broadcastrecieverapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    // Define Button
    private Button button;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate button from XML
        button = (Button) findViewById(R.id.buttonBroadcast);

        // Set listener on the button
        button.setOnClickListener(new View.OnClickListener() {

            // Override the onClick() method
            @Override
            public void onClick(View view) {
                // call the method that starts the Broadcast Intent
                broadcastIntent(view);
            }
        });
    }

    // Broadcast a custom intent.
    public void broadcastIntent(View view){

        // Create an Intent object
        Intent intent = new Intent();

        // Set action on the intent
        intent.setAction("com.romellbolton.CUSTOM_INTENT");

        // Send the broadcast with the Intent as a parameter
        sendBroadcast(intent);
    }
}
