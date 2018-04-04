package com.romellbolton.sharedpreferencesapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Define a SharedPreference object
    SharedPreferences sharedpreferences;

    // Define Views
    TextView name;
    TextView email;

    // Define preference name and key names
    public static final String MY_PREFERENCE = "myPref";
    public static final String NAME_KEY = "nameKey";
    public static final String EMAIL_KEY = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate the views from the XML file
        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);

        // Get the specific SharedPreference that was created
        sharedpreferences = getSharedPreferences(MY_PREFERENCE,
                Context.MODE_PRIVATE);

        // If the preference has a name key...
        if (sharedpreferences.contains(NAME_KEY)) {

            // Display the value of the name key in the TextView
            name.setText(sharedpreferences.getString(NAME_KEY, ""));
        }

        // If the preference has a email key...
        if (sharedpreferences.contains(EMAIL_KEY)) {

            // Display the value of the email key in the TextView
            email.setText(sharedpreferences.getString(EMAIL_KEY, ""));
        }
    }

    // saveData() saves data into the specific SharedPreference
    public void saveData(View view) {

        // Get the name typed in from the name text view
        String n = name.getText().toString();

        // Get the email typed in from the email text view
        String e = email.getText().toString();

        // Create a SharedPreference editor object
        SharedPreferences.Editor editor = sharedpreferences.edit();

        // Put the data into the preference, using key-value pairs
        editor.putString(NAME_KEY, n);
        editor.putString(EMAIL_KEY, e);

        // Commit the change to the preference
        editor.commit();

        // Display Data Saved message
        Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
    }

    // clearData() clears the data typed into the TextViews
    public void clearData(View view) {

        // Inflate the views from the XML file
        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);

        // Clear the TextViews
        name.setText("");
        email.setText("");

        // Display Data Cleared message
        Toast.makeText(MainActivity.this, "Data Cleared", Toast.LENGTH_SHORT).show();
    }

    // retrieveData() retrieves the data from the specific SharedPreference and displays it
    // in the text views if there is data in the preference
    public void retrieveData(View view) {

        // Inflate the views from the XML file
        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);

        // Get the specific SharedPreference that was created
        sharedpreferences = getSharedPreferences(MY_PREFERENCE,
                Context.MODE_PRIVATE);

        // If the preference has a name key...
        if (sharedpreferences.contains(NAME_KEY)) {

            // Display the value of the name key in the TextView
            name.setText(sharedpreferences.getString(NAME_KEY, ""));
        }

        // If the preference has a email key...
        if (sharedpreferences.contains(EMAIL_KEY)) {

            // Display the value of the email key in the TextView
            email.setText(sharedpreferences.getString(EMAIL_KEY, ""));
        }

        // Display Data Retrieved message
        Toast.makeText(MainActivity.this, "Data Retrieved", Toast.LENGTH_SHORT).show();
    }
}