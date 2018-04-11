package com.romellbolton.gridviewapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Declare GridView
    GridView gridView;

    // Create a String array of letters
    static final String[] letters = new String[]{
            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout
        setContentView(R.layout.activity_main);

        // Initialize the GridView
        gridView = (GridView) findViewById(R.id.gridView1);

        // Create an ArrayAdapter, passing the layout for individual data,
        // and the data itself (String array)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, letters);

        // Set the adapter on the GridView
        gridView.setAdapter(adapter);

        // Set an OnItemClickListener on the GridView
        gridView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // Create a Toast message displaying which view in the GridView was clicked
                Toast.makeText(getApplicationContext(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
