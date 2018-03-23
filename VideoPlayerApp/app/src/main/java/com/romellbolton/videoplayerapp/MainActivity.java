package com.romellbolton.videoplayerapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate the VideoView from the XML
        VideoView videoView = (VideoView) findViewById(R.id.vdVw);

        // Create MediaController to enable a VideoView to play, pause, forward, etc options.
        MediaController mediaController = new MediaController(this);

        // Use VideoView's parent layout as an anchor
        mediaController.setAnchorView(videoView);

        // Obtain Location of Media File via URI
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lion_sample);

        // Starting VideoView by Setting MediaController and URI, requesting focus, and starting
        // the video
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}
