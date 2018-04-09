package com.romellbolton.picassoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    // Declare ImageView
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the ImageView
        imageView = (ImageView) findViewById(R.id.imageView);

        // Loading Image from URL
        Picasso.with(this)
                .load("https://www.simplifiedcoding.net/wp-content/uploads/2015/10/advertise.png")
                .placeholder(R.drawable.placeholder) // Establish a placeholder image until the real image is displayed
                .error(R.drawable.error) // Put an error image if something goes wrong
                .resize(400,400) // Resize the image
                .into(imageView); // Specify the ImageView to load image into
    }
}
