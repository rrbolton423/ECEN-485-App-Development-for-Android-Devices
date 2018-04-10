package com.romellbolton.autocompletetextviewapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    // Define AutoCompleteTextView
    AutoCompleteTextView autocomplete;

    // Create String array containing the data to use in the autocomplete TextView
    String[] data = { "Paries,France", "PA,United States","Parana,Brazil",
            "Padua,Italy", "Pasadena,CA,United States"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the AutoCompleteTextView
        autocomplete = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView1);

        // Create an ArrayAdapter for the AutoCompleteTextView,
        // containing the String array 'data', and the
        // layout to put each individual data item into 'select_dialog_item'.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, data);

        // setThreshold() sets the amount of characters the user has to type in before the
        // AutoComplete action takes effect. In this case, the user has to
        // enter one letter for the AutoComplete to pop up.
        autocomplete.setThreshold(1);

        // Set the ArrayAdapter on the AutoCompleteTextView
        autocomplete.setAdapter(adapter);
    }
}
