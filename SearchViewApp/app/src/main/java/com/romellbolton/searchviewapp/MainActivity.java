package com.romellbolton.searchviewapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    // Declare SearchView and ListView
    SearchView searchView;
    ListView listView;

    // Declare ArrayList and Adapter handling the String data
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the Views
        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.lv1);

        // Instantiate the ArrayList
        list = new ArrayList<>();

        // Add data to the ArrayList
        list.add("Apple");
        list.add("Banana");
        list.add("Pineapple");
        list.add("Orange");
        list.add("Lychee");
        list.add("Gavava");
        list.add("Peech");
        list.add("Melon");
        list.add("Watermelon");
        list.add("Papaya");

        // Instantiate ArrayAdapter, passing the context, layout for each data item, and the list
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        // Set the adapter on the ListView
        listView.setAdapter(adapter);

        // Set a OnQueryTextListener on the SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            // onQueryTextSubmit() is called when text is submitted into the SearchView for filter
            @Override
            public boolean onQueryTextSubmit(String query) {

                // If the ArrayList / ListView contains the query that was typed into the SearchView...
                if (list.contains(query)) {

                    // Filter the ArrayAdapter containing the data with the query submitted
                    // in the SearchView
                    adapter.getFilter().filter(query);

                    // If the ArrayList DOES NOT contains the query that was typed into the SearchView...
                } else {

                    // Create "No Match found" Toast message
                    Toast.makeText(MainActivity.this, "No Match found", Toast.LENGTH_LONG).show();
                }

                // Return false
                return false;
            }

            // onQueryTextChange() is called when text is changed in the SearchView
            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);

                /* Do nothing */

                // Return false
                return false;
            }
        });
    }
}
