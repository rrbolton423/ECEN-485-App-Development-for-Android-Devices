package com.romellbolton.preferencesscreenapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    // Declare TextView
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate Buttons
        Button storeInfoBtn = (Button) findViewById(R.id.storeinformation);
        Button showInfoBtn = (Button) findViewById(R.id.showinformation);

        // Instantiate TextView
        textView = (TextView) findViewById(R.id.txtPrefs);

        // Create a ClickListener
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the ID of the button that was clicked
                switch (v.getId()) {

                    // If the storeInfoBtn is clicked...
                    case R.id.storeinformation:

                        // Create an Intent to navigate to the Preferences Activity
                        Intent intent = new Intent(MainActivity.this, PrefsActivity.class);

                        // Start the Activity, passing the Intent
                        startActivity(intent);

                        // Break from the switch statement
                        break;

                    // If the showInfoBtn is clicked...
                    case R.id.showinformation:

                        // Display the preferences
                        displaySharedPreferences();

                        // Break from the switch statement
                        break;

                    // By default...
                    default:

                        // Break from the switch statement
                        break;
                }
            }
        };

        // Set the listeners on both buttons
        storeInfoBtn.setOnClickListener(listener);
        showInfoBtn.setOnClickListener(listener);
    }

    // displaySharedPreferences() displays the data in the shared preferences
    private void displaySharedPreferences() {

        // Get the SharedPreferences from the PreferenceActivity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        // Get the data from the preference object using the keys of the specific preference,
        // that was set in the prefs.xml file, and provide a default value if a preference
        // is not already set
        String username = prefs.getString("username", "Default NickName");
        String password = prefs.getString("password", "Default Password");
        boolean checkBox = prefs.getBoolean("checkBox", false);
        String listPrefs = prefs.getString("listpref", "Default list prefs");

        // Create a StringBuilder object
        StringBuilder builder = new StringBuilder();

        // Append the data from the preference object to the StringBuilder object
        builder.append("Username: " + username + "\n");
        builder.append("Password: " + password + "\n");
        builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
        builder.append("List preference: " + listPrefs);

        // Display the Preference data
        textView.setText(builder.toString());
    }
}
