package com.romellbolton.buttonapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Declare Button
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout
        setContentView(R.layout.activity_main);

        // Initialize Button
        button = (Button) findViewById(R.id.button1);

        // Set an OnClickListener on the Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create successful Toast message stating the button was clicked
                Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
