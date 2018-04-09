package com.romellbolton.imageviewapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mkyong.android.R;

public class MainActivity extends Activity {

    // Define Views
    Button button;
    ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Call the method that changes the image
        addListenerOnButton();
    }

    // addListenerOnButton() adds a click listener on the button widget and changes the image
    // when the button detects a click
    public void addListenerOnButton() {

        // Instantiate views
        image = (ImageView) findViewById(R.id.imageView1);
        button = (Button) findViewById(R.id.btnChangeImage);

        // Add click listener on the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                // Change the image resource
                image.setImageResource(R.drawable.android3d);
            }
        });
    }
}
