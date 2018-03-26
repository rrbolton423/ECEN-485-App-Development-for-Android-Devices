package com.romellbolton.serviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // onClick() starts the Service
    public void onClick(View view) {

        // Create an Intent to the Service class
        Intent intent = new Intent(this, MyService.class);

        // Start the Service, passing the Intent
        startService(intent);
    }
}
