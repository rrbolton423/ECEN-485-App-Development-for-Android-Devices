package com.romellbolton.listviewapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    // Define TextView to show the selected item in the ListView
    TextView selection;

    // Create a String array containing breakfast food items
    String[] items = {"eggs", "bacon", "orange juice", "pancakes", "waffles",
            "sausage", "coffee", "milk", "butter", "water",
            "toast", "honey", "biscuits", "hash browns", "french toast",
            "bagel", "potatoes", "yogurt", "tea", "donut",
            "grits", "rice", "muffin", "berries", "breakfast burrito"};

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // Inflate the main layout
        setContentView(R.layout.activity_main);

        // Set an ArrayAdapter containing Strings,
        // specifying the layout to display a single item in the list in,
        // as well as the list of items from the items String array
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                items));

        // Inflate the selection TextView
        selection = (TextView) findViewById(R.id.selection);
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {

        // Get the position of the item that was selected in the ListView
        // and set the selection TextView of the item that was selected
        selection.setText(items[position]);
    }
}