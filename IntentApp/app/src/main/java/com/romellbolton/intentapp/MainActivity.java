package com.romellbolton.intentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Create a constant for the key of the Intent to access the data
    public static final String EXTRA_MESSAGE = "extra_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {

        // Create an Intent object to navigate to the DisplayMessageActivity
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        // Inflate the EditText widget in the XML
        EditText editText = (EditText) findViewById(R.id.editText);

        // Get the text from the EditText widget and convert it to a String
        String message = editText.getText().toString();

        // Package the String into the Intent object as extra data
        intent.putExtra(EXTRA_MESSAGE, message);

        // Start the activity, passing the intent object with the data
        startActivity(intent);
    }
}
