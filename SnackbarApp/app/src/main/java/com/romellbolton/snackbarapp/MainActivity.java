package com.romellbolton.snackbarapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    // Define Button
    private Button button;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate Button from XML
        button = (Button) findViewById(R.id.buttonSnackbar);

        // Set listener on the Button
        button.setOnClickListener(new View.OnClickListener() {

            // Override onClick() method
            @Override
            public void onClick(View view) {

                // Create Snackbar
                Snackbar.make(view, "This is a Snackbar!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
