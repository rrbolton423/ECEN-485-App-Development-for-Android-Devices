package com.romellbolton.animationapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Define ImageView and Button
    private ImageView androidRobot;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find Views By ID
        button = (Button) findViewById(R.id.button);
        androidRobot = (ImageView) findViewById(R.id.imgAndroidRobot);

        // Set the Image off-screen
        androidRobot.setTranslationX(-1000f);
        androidRobot.setTranslationY(-1000f);

        // Set a Listener on the button
        button.setOnClickListener(new View.OnClickListener() {

            // Override the onClick() method
            @Override
            public void onClick(View v) {
                // Animate the ImageView
                androidRobot.animate()
                        // Move it's X position by 1000
                        .translationXBy(1000f)
                        // Move it's Y position by 1000
                        .translationYBy(1000f)
                        // Scale the size of the ImageView
                        .scaleX(0.5f).scaleY(0.5f)
                        // Rotate the Image View
                        .rotationBy(3600)
                        // Do the animation for 5 seconds
                        .setDuration(5000);
            }
        });
    }
}
