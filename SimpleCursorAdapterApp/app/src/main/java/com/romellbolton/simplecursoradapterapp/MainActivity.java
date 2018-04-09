package com.romellbolton.simplecursoradapterapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    // Define SimpleCursorAdapter
    SimpleCursorAdapter adapter;

    // Define Views
    EditText nameEditText, emailEditText;
    Button addButton, showButton;
    ListView listView;

    // Define String data
    String nameString, emailString;

    // Define the column names for adapter to get the data from
    String[] from = {"name_col", "email_col"};

    // Define views to send data to
    int[] to = {R.id.nameEditText, R.id.emailEditText};

    // Define Database Helper
    HelperDB helperDB;

    // Define cursor object
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate view's from XML file
        nameEditText = (EditText) findViewById(R.id.etName);
        emailEditText = (EditText) findViewById(R.id.etEmail);
        addButton = (Button) findViewById(R.id.add);
        showButton = (Button) findViewById(R.id.show);
        listView = (ListView) findViewById(R.id.listView);

        // Instantiate Database Helper object
        helperDB = new HelperDB(this);

        // Set click listener on the addButton
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the name data from the name edit text view
                nameString = nameEditText.getText().toString();

                // Get the email data from the email edit text view
                emailString = emailEditText.getText().toString();

                // If there ISN'T data typed into the edit text views...
                if (nameString.equals("") || emailString.equals("")) {

                    // Display error message
                    Toast.makeText(getApplicationContext(), "please enter all fields!!", Toast.LENGTH_SHORT).show();

                    // If there IS data typed into the edit text views...
                } else {

                    // Insert the data into the database
                    boolean b = helperDB.insertStudent(nameString, emailString);

                    // Display success message
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

                    // Clear the data from the name edit text view
                    nameEditText.setText("");

                    // Clear the data from the email edit text view
                    emailEditText.setText("");
                }
            }
        });

        // Set click listener on the showButton
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get all data from the database
                cursor = helperDB.getData();

                // Move the the beginning of the cursor
                cursor.moveToFirst();

                // If the cursor contains data...
                if (cursor.getCount() > 0) {

                    // Instantiate the SimpleCursorAdapter, passing as arguments...
                    // 1. the context
                    // 2. the list view row to put the data into
                    // 3. the cursor containing the data
                    // 4. the database column names in the cursor to get the data from
                    // 5. the list view rows to put the data from the cursor's specified database columns
                    // 6. the flags argument (0)
                    adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.list_view_row, cursor, from, to, 0);
                }

                // Set the adapter on the ListView
                listView.setAdapter(adapter);

                // Make the ListView visible
                listView.setVisibility(View.VISIBLE);
            }
        });
    }
}
