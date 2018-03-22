package com.romellbolton.mediaplayerapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Define Button
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a MediaPlayer object, providing the context and the media file
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.applause);

        // Inflate the button from the XML
        button = (Button) this.findViewById(R.id.buttonMedia);

        // Set a listener on the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Play the media
                mediaPlayer.start();
            }
        });
    }
}
