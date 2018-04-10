package com.romellbolton.imagebuttonapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Declare ImageButton
    ImageButton imgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate ImageButton
        imgButton =(ImageButton)findViewById(R.id.imageButton);

        // Set onClickListener on the ImageButton
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a toast message saying the button was clicked
                Toast.makeText(MainActivity.this, "Image Button Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
