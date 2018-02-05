package com.romellbolton.guiappv3;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

// MainActivity extends ListActivity
public class MainActivity extends ListActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate Button
        button = (Button) findViewById(R.id.button);

        // Inflate CheckBox
        checkbox = (CheckBox) findViewById(R.id.checkBox);

        // Inflate RadioButton
        radioButton = (RadioButton) findViewById(R.id.radioButton);

        // Set the Adapter on the ListView
        setListAdapter(itemsAdapter);

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
                setListAdapter(itemsAdapter);

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
                setListAdapter(itemsAdapter);
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
                setListAdapter(itemsAdapter);
            }
        });
    }
}
