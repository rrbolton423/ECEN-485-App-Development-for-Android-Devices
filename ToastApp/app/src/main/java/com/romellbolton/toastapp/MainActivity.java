package com.romellbolton.toastapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Define button
    private Button button;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate button from XML
        button = (Button) findViewById(R.id.buttonToast);

        // Set listener on the button
        button.setOnClickListener(new View.OnClickListener() {

            // Override onClick() method
            @Override
            public void onClick(View arg0) {

                // Create Toast message
                Toast.makeText(getApplicationContext(),
                        "This is a Toast", Toast.LENGTH_LONG).show();
            }
        });
    }
}
