package com.romellbolton.ratingbarapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Define Views
    private RatingBar ratingBar;
    private TextView txtRatingValue;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add listeners on Views
        addListenerOnRatingBar();
        addListenerOnButton();
    }

    // Method adds a listener on the RatingBar
    public void addListenerOnRatingBar() {

        // Instantiate the Views
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);

        // Set a OnRatingBarChangeListener on the RatingBar.
        // If rating value is changed...
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                // Display the current rating value in the result (TextView) automatically
                txtRatingValue.setText(String.valueOf(rating));
            }
        });
    }

    // Method adds a listener on the Button
    public void addListenerOnButton() {

        // Instantiate the Views
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        // Set a OnClickListener on the Button
        // If the button is clicked...
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Display the current rating value in a Toast message
                Toast.makeText(MainActivity.this,
                        String.valueOf(ratingBar.getRating()),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}