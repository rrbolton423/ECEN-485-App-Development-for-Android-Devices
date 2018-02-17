/* Copyright (c) 2008-2009 -- CommonsWare, LLC

	 Licensed under the Apache License, Version 2.0 (the "License");
	 you may not use this file except in compliance with the License.
	 You may obtain a copy of the License at

		 http://www.apache.org/licenses/LICENSE-2.0

	 Unless required by applicable law or agreed to in writing, software
	 distributed under the License is distributed on an "AS IS" BASIS,
	 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 See the License for the specific language governing permissions and
	 limitations under the License.
*/

package com.romellbolton.sharedpreferencesapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.commonsware.android.prefdialogs.R;


public class MainActivity extends Activity {

    // ID of the only Menu item to navigate to the EditPreference's Activity
    private static final int EDIT_ID = Menu.FIRST + 2;

    // View's to display preferences set in the EditPreference's Activity,
    // in the MainActivity Activity
    // Define the UI of the MainActivity
    private TextView checkbox = null;
    private TextView ringtone = null;
    private TextView checkbox2 = null;
    private TextView text = null;
    private TextView list = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Inflate the UI of the MainActivity
        checkbox = (TextView) findViewById(R.id.checkbox);
        ringtone = (TextView) findViewById(R.id.ringtone);
        checkbox2 = (TextView) findViewById(R.id.checkbox2);
        text = (TextView) findViewById(R.id.text);
        list = (TextView) findViewById(R.id.list);
    }

    // The UI fields are updated in the onResume() method, A.K.A when the user
    // returns from the Preferences Activity to the MainActivity
    @Override
    public void onResume() {
        super.onResume();

        // Get the SharedPreferences that were set in the EditPreference's Activity
        // You do this by using the PreferenceManager's getDefaultSharedPreferences() method
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);

        // Update the UserInterface in the MainActivity by using the key to access the value
        // of the updated SharedPreferences

        // Set the TextView to the value of the CheckboxPreference from the EditPreference Activity.
        // Access the CheckboxPreference's value via it's "checkbox" key.
        // If nothing changed, get and set the default value of "false".
        checkbox.setText(
                Boolean.toString(
                        prefs.getBoolean("checkbox", false)));

        // Set the TextView to the value of the RingtonePreference from the EditPreference Activity.
        // Access the RingtonePreference's value via it's "ringtone" key.
        // If nothing changed, get and set the default value of "unset".
        ringtone.setText(
                prefs.getString("ringtone", "<unset>"));

        // Set the TextView to the value of the CheckboxPreference from the EditPreference Activity.
        // Access the CheckboxPreference's value via it's "checkbox2" key.
        // If nothing changed, get and set the default value of false.
        checkbox2.setText(
                Boolean.toString(
                        prefs.getBoolean("checkbox2", false)));

        // Set the TextView to the value of the EditTextPreference from the EditPreference Activity.
        // Access the EditTextPreference's value via it's "text" key.
        // If nothing changed, get and set the default value of "unset".
        text.setText(
                prefs.getString("text", "<unset>"));

        // Set the TextView to the value of the ListPreference from the EditPreference Activity.
        // Access the ListPreference's value via it's "list" key.
        // If nothing changed, get and set the default value of "unset".
        list.setText(
                prefs.getString("list", "<unset>"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Add the Menu to the MainActivity
        menu.add(Menu.NONE, EDIT_ID, Menu.NONE, "Edit Prefs")
                .setIcon(R.drawable.misc)
                .setAlphabeticShortcut('e');

        return (super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Get the ID of the item that was selected from the menu
        switch (item.getItemId()) {

            // When the only menu item is selected ...
            case EDIT_ID:

                // Start the Activity to navigate to the EditPreferences Activity
                startActivity(new Intent(this, EditPreferences.class));

                // Return true since the method executed successfully
                return (true);
        }

        return (super.onOptionsItemSelected(item));
    }
}
