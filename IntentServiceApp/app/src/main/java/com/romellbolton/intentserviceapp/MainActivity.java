package com.romellbolton.intentserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Define Button
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate button from the XML
        button = (Button) findViewById(R.id.buttonService);

        // Set listener on the button
        button.setOnClickListener(new View.OnClickListener() {
            // Override the onClick() method
            @Override
            public void onClick(View view) {

                // Create an Intent object navigating to the Service class
                Intent intent = new Intent(MainActivity.this, Service.class);

                // Start the service, passing the Intent
                startService(intent);

                // Create Toast message
                Toast.makeText(MainActivity.this, "Service Started!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
