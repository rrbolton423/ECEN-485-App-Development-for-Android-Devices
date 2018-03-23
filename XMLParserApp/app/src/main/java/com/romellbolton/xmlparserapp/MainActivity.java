package com.romellbolton.xmlparserapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Define ListView
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate ListView from the XML
        listView = (ListView) findViewById(R.id.list);

        // Initialize a list to null
        List<Employee> employeeList = null;

        try {
            // Create an instance of an XMLParser
            SimpleXMLPullParser parser = new SimpleXMLPullParser();

            // Initialize the list using the parse() method, passing it
            // a local XML file from the assets directory
            employeeList = parser.parse(getAssets().open("employees.xml"));

            // Create an ArrayAdapter, passing it a layout for each item, and the list of data
            // The ArrayAdapter calls the toString() method of each item in the employee list,
            // formatting the text in it's onBindView() method
            ArrayAdapter<Employee> adapter =
                    new ArrayAdapter<Employee>(this, R.layout.list_item, employeeList);

            // Set the adapter on the ListView
            listView.setAdapter(adapter);

            // Catch an IOException
        } catch (IOException e) {

            // Print the stacktrace
            e.printStackTrace();
        }
    }
}
