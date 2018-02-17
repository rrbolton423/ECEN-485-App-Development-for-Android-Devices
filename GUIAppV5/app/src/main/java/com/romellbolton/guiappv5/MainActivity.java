package com.romellbolton.guiappv5;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
public class MainActivity extends AppCompatActivity {

    // Define array of numbers
    String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};

    // Define array of letters
    String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    // Define array of text
    String[] text = {"eggs", "bacon", "orange juice", "pancakes", "waffles",
            "sausage", "coffee", "milk", "butter", "water",
            "toast", "honey", "biscuits", "hash browns", "french toast",
            "bagel", "potatoes", "yogurt", "tea", "donut",
            "grits", "rice", "muffin", "berries", "breakfast burrito"};

    // Define ArrayAdapter
    ArrayAdapter<String> itemsAdapter;

    // Define Button
    Button button;

    // Define CheckBox
    CheckBox checkbox;

    // Define RadioButton
    RadioButton radioButton;

    // Define ListView
    ListView myListView;

    // Define LinearLayout
    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inflate Button
        button = (Button) findViewById(R.id.button);

        // Inflate CheckBox
        checkbox = (CheckBox) findViewById(R.id.checkBox);

        // Inflate RadioButton
        radioButton = (RadioButton) findViewById(R.id.radioButton);

        // Inflate ListView
        myListView = (ListView) findViewById(R.id.myListView);

        // Inflate Linear Layout
        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        // Set the Adapter on the ListView
        myListView.setAdapter(itemsAdapter);

        // Set onClickListener on the Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // un-check other views
                radioButton.setChecked(false);

                // un-check other views
                checkbox.setChecked(false);

                // Create a new Adapter displaying the number items
                itemsAdapter =
                        new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, numbers);

                // Set the Adapter on the ListView with the new data to display
                myListView.setAdapter(itemsAdapter);

            }
        });

        // Set an onCheckChangeListener on the CheckBox
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                // If the CheckBox is checked ...
                if (isChecked) {

                    // un-check other views
                    radioButton.setChecked(false);

                }

                // Create a new Adapter displaying the letter items
                itemsAdapter =
                        new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, letters);

                // Set the Adapter on the ListView with the new data to display
                myListView.setAdapter(itemsAdapter);
            }
        });

        // Set an onCheckChangeListener on the RadioButton
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                // If the RadioButton is checked ...
                if (isChecked) {

                    // un-check other views
                    checkbox.setChecked(false);

                    // check the RadioButton
                    radioButton.setChecked(true);

                }

                // Create a new Adapter displaying the text items
                itemsAdapter =
                        new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, text);

                // Set the Adapter on the ListView with the new data to display
                myListView.setAdapter(itemsAdapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //  If the website menu item is selected ...
        if (id == R.id.action_website) {

            // Create Intent Object to navigate to the WebView Activity
            Intent intent = new Intent(getApplicationContext(), com.romellbolton.guiappv5.WebViewActivity.class);

            // Start the intent
            startActivity(intent);

            //  If the light mode menu item is selected ...
        } else if (id == R.id.action_light_mode) {

            // Set the layout to white
            mLinearLayout.setBackgroundColor(Color.WHITE);

            //  If the dark mode menu item is selected ...
        } else if (id == R.id.action_dark_mode) {

            // Set the layout to dark gray
            mLinearLayout.setBackgroundColor(Color.DKGRAY);

            // If the Thread menu item is selected ...
        } else if (id == R.id.run_thread) {

            // Create a new Thread object, implementing it's run interface
            Thread thread = new Thread()
            {
                // In the run method, start an Activity on a background thread
                @Override
                public void run()
                {
                    // Create Intent Object to navigate to the Thread Activity
                    Intent intent = new Intent(getApplicationContext(), com.romellbolton.guiappv5.ThreadActivity.class);

                    // Start the intent
                    startActivity(intent);
                }
            };

            // Run the background thread
            thread.run();

        }

        return super.onOptionsItemSelected(item);
    }
}
