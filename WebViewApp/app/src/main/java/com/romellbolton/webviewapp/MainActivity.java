package com.romellbolton.webviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Declare a Button object
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate the Button widget
        button = (Button) findViewById(R.id.buttonUrl);

        // Set an onClickListener interface on the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create Intent Object to navigate to the WebView Activity
                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);

                // Start the intent
                startActivity(intent);
            }
        });
    }
}
